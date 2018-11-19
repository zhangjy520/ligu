/**
 * Created by zjy on 2018/5/20.
 * app配置管理（文档增删改）
 */
package cc.ligu.mvc.controller;

import cc.ligu.common.controller.BasicController;
import cc.ligu.common.utils.DWZResponseUtil;
import cc.ligu.common.utils.DicUtil;
import cc.ligu.common.utils.PropertiesUtil;
import cc.ligu.mvc.modelView.DWZResponse;
import cc.ligu.mvc.persistence.entity.ProjectReport;
import cc.ligu.mvc.service.ProjectReportService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/projectReport")
@Controller
public class ProjectReportController extends BasicController {

    @Autowired
    ProjectReportService projectReportService;

    @RequestMapping(value = "/index")
    public String configIndex(HttpServletRequest request, Model model) {
        PageInfo<ProjectReport> pageInfo = projectReportService.listAllProjectReport(getPageSize(request), getPageNum(request), null);

        model.addAttribute("pageInfo", pageInfo);
        return "projectReport/index";
    }

    @RequestMapping("/pop/modify")
    public String popAdd(Model model, HttpServletRequest request) {
        String id = getParamVal(request, "id");
        String type = getParamVal(request, "type");
        if (!StringUtils.isEmpty(id)) {
            ProjectReport projectReport = projectReportService.selectProjectReportByPrimary(Integer.parseInt(id));
            model.addAttribute("projectReport", projectReport);
            if ("view".equals(type)) {
                model.addAttribute("disabled", "disabled");
                model.addAttribute("type", "view");
            }
        }
        return "projectReport/pop/editReport";
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public DWZResponse saveDocument(HttpServletRequest request, Model model, ProjectReport projectReport) {
        try {
            List<String> urlList = DicUtil.splitWithOutNull(projectReport.getProjectPic());
            String urls = "";
            for (String url : urlList) {
                urls += request.getScheme() + "://" + request.getServerName() + ":" + PropertiesUtil.getProperties("db.properties").get("nginx.static.port") + url+",";
            }
            projectReport.setProjectPic(urls);
            projectReportService.saveProjectReport(projectReport, getLoginUser());
        } catch (Exception e) {
            e.printStackTrace();
            return DWZResponseUtil.callbackFail("300", "保存", "");
        }
        return DWZResponseUtil.callbackSuccess("保存成功", "_blank");
    }

}
