/**
 * Created by zjy on 2018/5/20.
 * app配置管理（文档增删改）
 */
package cc.ligu.mvc.controller;

import cc.ligu.common.controller.BasicController;
import cc.ligu.common.utils.DWZResponseUtil;
import cc.ligu.common.utils.PropertiesUtil;
import cc.ligu.mvc.modelView.DWZResponse;
import cc.ligu.mvc.persistence.entity.AppConfig;
import cc.ligu.mvc.service.AppConfigService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/appConfig")
@Controller
public class AppConfigController extends BasicController {

    @Autowired
    AppConfigService appConfigService;

    @RequestMapping(value = "/index")
    public String configIndex(HttpServletRequest request, Model model) {
        PageInfo<AppConfig> pageInfo = appConfigService.listAllAppConfig(getPageSize(request), getPageNum(request), null);

        model.addAttribute("pageInfo", pageInfo);
        return "app/index";
    }

    @RequestMapping("/pop/modify")
    public String popAdd(Model model, HttpServletRequest request) {
        String id = getParamVal(request, "id");
        if (!StringUtils.isEmpty(id)) {
            AppConfig appConfig = appConfigService.selectAppConfigByPrimary(Integer.parseInt(id));
            model.addAttribute("appConfig", appConfig);
        }
        return "app/pop/editConfig";
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public DWZResponse saveDocument(HttpServletRequest request, Model model, AppConfig appConfig) {
        try {
            appConfig.setConfigValue(request.getScheme() + "://" + request.getServerName() + ":" + PropertiesUtil.getProperties("db.properties").get("nginx.static.port") + appConfig.getConfigValue());
            appConfigService.saveAppConfig(appConfig);
        } catch (Exception e) {
            e.printStackTrace();
            return DWZResponseUtil.callbackFail("300", "保存配置", "");
        }
        return DWZResponseUtil.callbackSuccess("保存配置成功", "_blank");
    }

}
