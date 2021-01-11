/**
 * Created by zjy on 2018/5/20. 文档管理（文档增删改）
 */
package cc.ligu.mvc.api;

import com.alibaba.fastjson.JSONObject;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import cc.ligu.common.controller.BasicController;
import cc.ligu.common.entity.ResultEntity;
import cc.ligu.mvc.persistence.entity.AppConfig;
import cc.ligu.mvc.service.MoneyService;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;

@RestController
@RequestMapping(value = "/api")
public class ApiController extends BasicController {
    @Resource
    MoneyService moneyService;

    public static void te() {
        List<String> url = JsoupGetArticleUrl.getCsdnBlogsUrl();
        for (String s : url) {
            HttpRequest request = HttpUtil.createGet(s);
            request.execute().body();
        }
        System.out.println("刷新流量，访问：【" + url.size() + "】篇博客成功，");
    }

    public static String realIP(HttpServletRequest request) {
        String xff = request.getHeader("x-forwarded-for");
        if (xff != null) {
            return xff.trim() + request.getRemoteAddr() + request.getLocalPort() + request.getRemotePort()
                + request.getServerPort();
        }
        return request.getRemoteAddr() + request.getLocalPort() + request.getRemotePort() + request
            .getServerPort();
    }

    @ApiOperation(value = "通过基金名称，基金金额计算当日收益", httpMethod = "GET", notes = "")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", dataType = "String", name = "nameList", value = "基金名称集合逗号隔开", required = true),
        @ApiImplicitParam(paramType = "query", dataType = "String", name = "numList", value = "基金金额集合逗号隔开", required = true),})
    @RequestMapping("/queryMoney")
    public ResultEntity queryMoney(HttpServletRequest request) {
        String nameList = request.getParameter("nameList");
        String numList = request.getParameter("numList");
        Map res =
            moneyService.calcDetail(Arrays.asList(nameList.split(",")), Arrays.asList(numList.split(",")));
        res.put("当前服务器", realIP(request));
        return ResultEntity.newResultEntity(res);
    }

    @ResponseBody
    @RequestMapping(value = "/queryMoney1", method = RequestMethod.POST)
    public ResultEntity queryMoney1(HttpServletRequest request, AppConfig appConfig) {
        return ResultEntity.newResultEntity(appConfig);
    }

    @ApiOperation(value = "通过客户端id判断是否需要登录", httpMethod = "POST", notes = "验证是否需要登录,不需要登录返回用户信息")
    @RequestMapping("/view")
    public ResultEntity checkIfLogin(HttpServletRequest request) {
        System.out.println(System.currentTimeMillis());
        while (true) {
            try {
                te();
                Thread.sleep(50000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
