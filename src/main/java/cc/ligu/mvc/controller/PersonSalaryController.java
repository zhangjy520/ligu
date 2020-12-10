/**
 * Created by zjy on 2018/5/20.
 * app配置管理（文档增删改）
 */
package cc.ligu.mvc.controller;

import cc.ligu.common.controller.BasicController;
import cc.ligu.common.utils.DWZResponseUtil;
import cc.ligu.common.utils.DicUtil;
import cc.ligu.common.utils.PropertiesUtil;
import cc.ligu.common.utils.excel.ExportExcel;
import cc.ligu.common.utils.excel.ImportExcel;
import cc.ligu.mvc.modelView.DWZResponse;
import cc.ligu.mvc.persistence.entity.PersonSalary;
import cc.ligu.mvc.service.PersonSalaryService;
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

@RequestMapping("/personSalary")
@Controller
public class PersonSalaryController extends BasicController {

    private static final String dateRegEx = "^[0-9]{4}-[0,1]{1}[0-9]{1}$";
    @Autowired
    PersonSalaryService personSalaryService;

    @RequestMapping(value = "/index")
    public String personIndex(HttpServletRequest request, Model model) {
        String name = getParamVal(request, "name");
        PersonSalary person = new PersonSalary();
        person.setPersonName(name);
        PageInfo<PersonSalary> pageInfo = personSalaryService.listAllPersonSalary(getPageSize(request), getPageNum(request), person);
        model.addAttribute("pageInfo", pageInfo);

        model.addAttribute("chooseName", name);
        return "personSalary/index";
    }

    @RequestMapping("/pop/modify")
    public String popAdd(Model model, HttpServletRequest request) {
        String id = getParamVal(request, "id");
        String check = getParamVal(request, "check");
        if (!StringUtils.isEmpty(id)) {
            PersonSalary person = personSalaryService.selectPersonSalaryByPrimary(Integer.parseInt(id));
            model.addAttribute("person", person);
            model.addAttribute("flag", true);//修改页面不可修改字段标识
        }
        if (!StringUtils.isEmpty(check)) {
            model.addAttribute("disabled", "disabled");
        }

        return "personSalary/pop/editPerson";
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public DWZResponse savePerson(Model model, PersonSalary person, HttpServletRequest request) {
        try {

            if ((!StringUtils.isEmpty(person.getSendTime()) && !person.getSendTime().matches(dateRegEx))) {
                //如果工资结算时间，或者生活费结算时间的格式不符合2019-01 不允许导入
                return DWZResponseUtil.callbackFail("300", "填写失败,日期格式yyyy-mm", "_blank");
            }
            personSalaryService.savePersonSalary(person);
        } catch (Exception e) {
            return DWZResponseUtil.callbackFail("300", "保存失败", "_blank");
        }
        return DWZResponseUtil.callbackSuccess("保存成功", "_blank");
    }

    @ResponseBody
    @RequestMapping(value = "/batch_delete", method = RequestMethod.POST)
    public DWZResponse batchdeletePersonSalary(Model model, HttpServletRequest request) {
        try {
            String ids = getParamVal(request, "ids");
            List<String> idList = DicUtil.splitWithOutNull(ids);
            for (String id : idList) {
                try {
                    deletePersonSalary(model, Integer.parseInt(id));
                } catch (Exception e) {
                    continue;
                }
            }
        } catch (Exception e) {
            return DWZResponseUtil.callbackFail("300", "删除失败", "_blank");
        }
        return DWZResponseUtil.callbackSuccess("删除成功", "_blank");
    }


    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public DWZResponse deletePersonSalary(Model model, @PathVariable("id") int id) {
        try {
            personSalaryService.deletePersonSalary(id);
        } catch (Exception e) {
            return DWZResponseUtil.callbackFail("300", "删除失败", "_blank");
        }
        return DWZResponseUtil.callbackSuccess("删除成功", "_blank");
    }

    //人员模版下载
    @ResponseBody
    @RequestMapping(value = "/template/download")
    public void exportMoban(HttpServletResponse response) {
        try {
            String fileName = "人员薪资导入模板.xlsx";
            String anno = "注释：橙色字段为必填项\n" +
                    "1.日期格式：2012-09;" +
                    "必须按照该格式填写";

            new ExportExcel("人员薪资导入模板", PersonSalary.class, 2, 50, anno, 1).setDataList(new ArrayList()).write(response, fileName).dispose();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //导入页面
    @RequestMapping("/pop/upload")
    public String popUpload() {
        return "personSalary/pop/uploadPerson";
    }


    //导入人员薪资库数据页面提交
    @ResponseBody
    @RequestMapping(value = "/import/save", method = RequestMethod.POST)
    public DWZResponse importExcel(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) throws Exception {
        Long begin = System.currentTimeMillis();
        String zhengMingUrls = getParamVal(request, "projectPic");
        String schme = "http";
        if (!StringUtils.isEmpty(request.getScheme())){
            schme = request.getScheme();
        }
        String itemPath = schme + "://" + request.getServerName() + ":" + PropertiesUtil.getProperties("db.properties").get("nginx.static.port");
        List<String> attachList = DicUtil.splitWithOutNull(zhengMingUrls);
        if (attachList == null) {
            attachList = new ArrayList<>();
        }
        String attachUrls = "";
        for (String url : attachList) {
            attachUrls += itemPath + url + ",";
        }

        ImportExcel importExcel = new ImportExcel(file, 2, 0);
        List<PersonSalary> list = importExcel.getDataList(PersonSalary.class, 1);

        for (PersonSalary person : list) {
            try {

                if ((!StringUtils.isEmpty(person.getSendTime()) && !person.getSendTime().matches(dateRegEx))) {
                    //如果工资结算时间，或者生活费结算时间的格式不符合2019-01 不允许导入
                    return DWZResponseUtil.callbackFail("300", "导入失败,请按照规则填写模版，日期格式yyyy-mm", "_blank");
                }

                person.setZhengJuUrls(attachUrls);
                personSalaryService.savePersonSalary(person);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
        Long end = System.currentTimeMillis();
        return DWZResponseUtil.callbackSuccess("导入成功，耗时" + (end - begin) / 1000 + "秒", "_blank");

    }
}
