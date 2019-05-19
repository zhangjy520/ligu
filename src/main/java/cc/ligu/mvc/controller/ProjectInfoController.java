/**
 * Created by zjy on 2018/5/20.
 * 工程信息管理
 */
package cc.ligu.mvc.controller;

import cc.ligu.common.controller.BasicController;
import cc.ligu.common.utils.DWZResponseUtil;
import cc.ligu.common.utils.DicUtil;
import cc.ligu.common.utils.excel.ExportExcel;
import cc.ligu.common.utils.excel.ImportExcel;
import cc.ligu.mvc.modelView.DWZResponse;
import cc.ligu.mvc.persistence.entity.*;
import cc.ligu.mvc.service.ProjectInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequestMapping("/projectInfo")
@Controller
public class ProjectInfoController extends BasicController {

    @Autowired
    ProjectInfoService projectInfoService;

    @RequestMapping(value = "/index")
    public String projectInfoIndex(HttpServletRequest request, Model model) {
        PageInfo<ProjectInfo> pageInfo = projectInfoService.listAllProjectInfo(getPageSize(request), getPageNum(request), new ProjectInfo());
        model.addAttribute("pageInfo", pageInfo);
        return "projectInfo/index";
    }

    @RequestMapping("/pop/modify")
    public String popAdd(Model model, HttpServletRequest request) {
        String id = getParamVal(request, "id");
        if (!StringUtils.isEmpty(id)) {
            ProjectInfo projectInfo = projectInfoService.selectProjectInfoByPrimary(Integer.parseInt(id));
            model.addAttribute("projectInfo", projectInfo);
        }
        return "projectInfo/pop/editProjectInfo";
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public DWZResponse saveProjectInfo(Model model, ProjectInfo projectInfo) {
        try {
            projectInfoService.saveProjectInfo(projectInfo, getLoginUser());
        } catch (Exception e) {
            return DWZResponseUtil.callbackFail("300", "保存工程信息失败", "");
        }
        return DWZResponseUtil.callbackSuccess("保存工程信息成功", "_blank");
    }


    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public DWZResponse deleteProjectInfo(Model model, @PathVariable("id") int id) {
        try {
            ProjectInfo projectInfo = new ProjectInfo();
            projectInfo.setId(id);
            projectInfoService.deleteProjectInfo(projectInfo);
        } catch (Exception e) {
            return DWZResponseUtil.callbackFail("300", "删除工程信息失败", "");
        }
        return DWZResponseUtil.callbackSuccess("删除工程信息成功", "");
    }

    //工程信息模版下载
    @ResponseBody
    @RequestMapping(value = "/template/download")
    public void exportMoban(HttpServletResponse response) {
        try {
            String fileName = "工程信息导入模板.xlsx";
            String anno = "注释：橙色字段为必填项\n" +
                    "请严格按照格式填写";

            new ExportExcel("工程信息导入模板", ProjectInfo.class, 2, 50, anno, 1).setDataList(new ArrayList()).write(response, fileName).dispose();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //工程信息导入页面
    @RequestMapping("/pop/upload")
    public String popUpload(Model model, HttpServletRequest request) {
        return "projectInfo/pop/uploadProjectInfo";
    }

    //导入工程信息页面提交
    @ResponseBody
    @RequestMapping(value = "/import/save", method = RequestMethod.POST)
    public DWZResponse importExcel(@RequestParam(value = "file") MultipartFile file) throws Exception {
        Long begin = System.currentTimeMillis();

        ImportExcel importExcel = new ImportExcel(file, 2, 0);
        List<ProjectInfo> list = importExcel.getDataList(ProjectInfo.class, 1);
        UserView loginUser = getLoginUser();
        for (ProjectInfo projectInfo : list) {
            try {
                //先循环入库吧，到时候定了再加个批量插入
                projectInfoService.saveProjectInfo(projectInfo, loginUser);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }

        Long end = System.currentTimeMillis();

        return DWZResponseUtil.callbackSuccess("导入成功，耗时" + (end - begin) / 1000 + "秒", "_blank");

    }


    @ResponseBody
    @RequestMapping(value = "/batch_delete", method = RequestMethod.POST)
    public DWZResponse batchdeleteProjectInfo(Model model, HttpServletRequest request) {
        try {
            String ids = getParamVal(request, "ids");
            List<String> idList = DicUtil.splitWithOutNull(ids);

            if (idList.size() > 0) {
                projectInfoService.batchDeleteProjectInfo(idList);
            }
        } catch (Exception e) {
            return DWZResponseUtil.callbackFail("300", "删除失败", "_blank");
        }
        return DWZResponseUtil.callbackSuccess("删除成功", "_blank");
    }

}
