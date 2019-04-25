/**
 * Created by zjy on 2018/5/20.
 * app配置管理（文档增删改）
 */
package cc.ligu.mvc.controller;

import cc.ligu.common.controller.BasicController;
import cc.ligu.common.utils.DWZResponseUtil;
import cc.ligu.common.utils.PropertiesUtil;
import cc.ligu.mvc.modelView.DWZResponse;
import cc.ligu.mvc.persistence.entity.AppGuangGao;
import cc.ligu.mvc.service.AppGuangGaoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/appGuangGao")
@Controller
public class AppGuangGaoController extends BasicController {

    @Autowired
    AppGuangGaoService appGuangGaoService;

    @RequestMapping(value = "/index")
    public String GuangGaoIndex(HttpServletRequest request, Model model) {
        PageInfo<AppGuangGao> pageInfo = appGuangGaoService.listAllAppGuangGao(getPageSize(request), getPageNum(request), null);

        model.addAttribute("pageInfo", pageInfo);
        return "appGuangGao/index";
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public DWZResponse deleteItem(Model model, @PathVariable("id") int id) {
        try {
            appGuangGaoService.deleteGuangGao(id);
        } catch (Exception e) {
            return DWZResponseUtil.callbackFail("300", "删除失败", "");
        }
        return DWZResponseUtil.callbackSuccess("删除成功", "");
    }

    @RequestMapping("/pop/modify")
    public String popAdd(Model model, HttpServletRequest request) {
        String id = getParamVal(request, "id");
        if (!StringUtils.isEmpty(id)) {
            AppGuangGao appGuangGao = appGuangGaoService.selectAppGuangGaoByPrimary(Integer.parseInt(id));
            model.addAttribute("appGuangGao", appGuangGao);
        }
        return "appGuangGao/pop/editGuangGao";
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public DWZResponse saveDocument(HttpServletRequest request, Model model, AppGuangGao appGuangGao) {
        try {
            String schme = "http";
            if (!StringUtils.isEmpty(request.getScheme())) {
                schme = request.getScheme();
            }
            if (appGuangGao.getType()==0){
                appGuangGao.setContent(schme + "://" + request.getServerName() + ":" + PropertiesUtil.getProperties("db.properties").get("nginx.static.port") + appGuangGao.getContent());
            }

            appGuangGaoService.saveAppGuangGao(appGuangGao);
        } catch (Exception e) {
            e.printStackTrace();
            return DWZResponseUtil.callbackFail("300", "保存配置", "");
        }
        return DWZResponseUtil.callbackSuccess("保存配置成功", "_blank");
    }

}
