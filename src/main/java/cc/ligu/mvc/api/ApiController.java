/**
 * Created by zjy on 2018/5/20.
 * 文档管理（文档增删改）
 */
package cc.ligu.mvc.api;

import cc.ligu.common.controller.BasicController;
import cc.ligu.common.entity.ResultEntity;
import cc.ligu.common.security.AESencryptor;
import cc.ligu.common.utils.DWZResponseUtil;
import cc.ligu.common.utils.SessionTool;
import cc.ligu.mvc.modelView.DWZResponse;
import cc.ligu.mvc.persistence.entity.Item;
import cc.ligu.mvc.persistence.entity.UserView;
import cc.ligu.mvc.service.UserService;
import cc.ligu.mvc.service.impl.ItemServiceImpl;
import com.github.pagehelper.PageInfo;
import com.wordnik.swagger.annotations.*;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/api")
public class ApiController extends BasicController {

    @Resource
    ItemServiceImpl itemService;

    @Resource
    UserService userService;

    @ApiOperation(value = "通过客户端id判断是否需要登录", httpMethod = "POST", notes = "验证是否需要登录,不需要登录返回用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "client", value = "客户端id", required = true),
    })
    @RequestMapping("/getUser")
    public ResultEntity checkIfLogin(HttpServletRequest request) {
        String clientId = getParamVal(request, "client");
        Object user = SessionTool.getUserInfoFromSession(request, clientId);

        if (null == user) {
            return ResultEntity.newErrEntity("您需要登录，请重新登录");
        } else {
            return ResultEntity.newResultEntity(user);
        }
    }

    @ApiOperation(value = "退出登录", httpMethod = "POST", notes = "退出登录，清除服务端session")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "client", value = "客户端id", required = true),
    })
    @RequestMapping("/logout")
    public ResultEntity applogOut(HttpServletRequest request) {
        String clientId = getParamVal(request, "client");
        try {
            request.getSession().removeAttribute(clientId);
        } catch (Exception e) {
            return ResultEntity.newErrEntity("服务器内部异常");
        }
        return ResultEntity.newResultEntity("操作成功");
    }

    @ApiOperation(value = "登录接口", httpMethod = "POST", notes = "验证登录账号密码")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "username", value = "用户名", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "password", value = "密码", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "client", value = "客户端id", required = true),
    })
    @RequestMapping("/login")
    public ResultEntity login(HttpServletRequest request) {
        String username = getParamVal(request, "username");
        String password = getParamVal(request, "password");
        String clientId = getParamVal(request, "client");
        SessionTool.getUserInfoFromSession(request, clientId);
        UserView user = userService.selectUserViewByUsernameAndPassword(username, AESencryptor.encryptCBCPKCS5Padding(password));
        if (null == user) {
            return ResultEntity.newErrEntity("用户名或密码错误");
        } else {
            SessionTool.setUserInfo2Session(request, clientId, user);//将clientId作为key,
            return ResultEntity.newResultEntity(user);
        }
    }
}
