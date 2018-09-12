/**
 * Created by zjy on 2018/5/20.
 * 题库管理（题库增删改+导入）
 */
package cc.ligu.mvc.controller;

import cc.ligu.common.controller.BasicController;
import cc.ligu.common.security.AESencryptor;
import cc.ligu.common.utils.DWZResponseUtil;
import cc.ligu.common.utils.DicUtil;
import cc.ligu.common.utils.excel.ExportExcel;
import cc.ligu.common.utils.excel.ImportExcel;
import cc.ligu.mvc.modelView.BaoXianView;
import cc.ligu.mvc.modelView.DWZResponse;
import cc.ligu.mvc.persistence.entity.Person;
import cc.ligu.mvc.persistence.entity.UserView;
import cc.ligu.mvc.service.ItemService;
import cc.ligu.mvc.service.PersonService;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
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

@RequestMapping("/person")
@Controller
public class PersonController extends BasicController {

    @Autowired
    PersonService personService;
    @Autowired
    ItemService itemService;


    @RequestMapping(value = "/changePwdIndex")
    public String changePwdIndex(HttpServletRequest request, Model model) {
        return "changepwd";
    }

    @ResponseBody
    @RequestMapping(value = "/changePwdSave", method = RequestMethod.POST)
    public DWZResponse changePwdSave(HttpServletRequest request, Model model) {
        String sourcePwd = getParamVal(request, "sourcePwd");
        String newPwd = getParamVal(request, "newPwd");
        try {
            if (getLoginUser().getPassword().equals(AESencryptor.encryptCBCPKCS5Padding(sourcePwd))) {
                personService.changeUserPwd(getLoginUser().getId(), newPwd);
            } else {
                return DWZResponseUtil.callbackFail("300", "原密码错误", "_blank");
            }
        } catch (Exception e) {
            return DWZResponseUtil.callbackFail("300", "修改密码失败", "_blank");
        }

        return DWZResponseUtil.callbackSuccess("修改密码成功，请使用您的新密码重新登录", "_blank");
    }

    @RequestMapping(value = "/index")
    public String personIndex(HttpServletRequest request, Model model) {
        UserView userView = getLoginUser();
        String name = getParamVal(request, "name");
        String roleType = getParamVal(request, "roleType");
        int _type = StringUtils.isEmpty(roleType) ? 5 : Integer.valueOf(roleType);
        Person person = new Person();
        person.setName(name);
        person.setType(_type);
        PageInfo<Person> pageInfo = personService.listAllPerson(getPageSize(request), getPageNum(request), person);
        model.addAttribute("pageInfo", pageInfo);

        model.addAttribute("chooseName", name);
        model.addAttribute("roleType", _type);//区别施工人员管理，人工审核管理员管理，项目经理管理，施工管理员管理
        return "person/index";
    }

    @RequestMapping(value = "/index_black")
    public String personIndexBlack(HttpServletRequest request, Model model) {
        String name = getParamVal(request, "name");
        String roleType = getParamVal(request, "roleType");
        int _type = StringUtils.isEmpty(roleType) ? 5 : Integer.valueOf(roleType);
        Person person = new Person();
        person.setName(name);
        person.setType(_type);
        PageInfo<Person> pageInfo = personService.listAllPerson(getPageSize(request), getPageNum(request), person);
        model.addAttribute("pageInfo", pageInfo);

        model.addAttribute("chooseName", name);
        model.addAttribute("roleType", _type);//区别施工人员管理，人工审核管理员管理，项目经理管理，施工管理员管理
        return "person/index_black";
    }

    @RequestMapping("/pop/modify_black")
    public String popAddBlack(Model model, HttpServletRequest request) {
        String id = getParamVal(request, "id");

        if (!StringUtils.isEmpty(id)) {
            Person person = personService.selectPersonByPrimary(Integer.parseInt(id));
            model.addAttribute("person", person);
        }

        return "person/pop/blackPerson";
    }

    @ResponseBody
    @RequestMapping(value = "/save_black", method = RequestMethod.POST)
    public DWZResponse savePersonBlack(Model model, Person person, HttpServletRequest request) {
        try {
            person.setBlackFlag(1);//设置黑名单状态
            int roleType = (StringUtils.isEmpty(person.getType()) || person.getType() == 0 ? 5 : person.getType());
            //施工人员
            person.setRoleName(DicUtil.getValueByKeyAndFlag(roleType, "roles"));
            person.setRolePermission(DicUtil.getValueByKeyAndFlag(roleType, "permissions"));
            personService.savePerson(person, getLoginUser());
        } catch (Exception e) {
            return DWZResponseUtil.callbackFail("300", "保存失败", "");
        }
        return DWZResponseUtil.callbackSuccess("保存成功", "_blank");
    }

    @ResponseBody
    @RequestMapping(value = "/delete_black/{id}", method = RequestMethod.POST)
    public DWZResponse deletePersonBlack(Model model, @PathVariable("id") int id, HttpServletRequest request) {
        try {

            Person person = new Person();
            person.setId(id);
            person.setBlackFlag(Integer.valueOf(getParamVal(request, "black", "0")));

            if (person.getBlackFlag() == 0) {
                //如果是解除黑名单操作，需要把拉入黑名单原因清空。
                person.setRemark("");
            }

            personService.savePerson(person, getLoginUser());
        } catch (Exception e) {
            return DWZResponseUtil.callbackFail("300", "操作失败", "");
        }
        return DWZResponseUtil.callbackSuccess("操作成功", "");
    }

    @RequestMapping("/pop/modify")
    public String popAdd(Model model, HttpServletRequest request) {
        String id = getParamVal(request, "id");
        String roleType = getParamVal(request, "roleType");
        String check = getParamVal(request, "check");
        if (!StringUtils.isEmpty(id)) {
            Person person = personService.selectPersonByPrimary(Integer.parseInt(id));
            model.addAttribute("person", person);
        }
        if (!StringUtils.isEmpty(check)) {
            //如果审核选择不为空，只显示修改页面的审核选择，并把其他可修改的文本框置为不可修改！
            model.addAttribute("check", "check");
            model.addAttribute("disabled", "disabled");
        }
        model.addAttribute("itemList", itemService.listAllItem());
        model.addAttribute("roleType", roleType);
        return "person/pop/editPerson";
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public DWZResponse savePerson(Model model, Person person, HttpServletRequest request) {
        try {
            String insurancePurchasesNum = getParamVal(request, "insurancePurchasesNum");
            String insurancePurchasesCompany = getParamVal(request, "insurancePurchasesCompany");
            String insurancePurchasesTime = getParamVal(request, "insurancePurchasesTime");
            String insurancePurchasesHowMuch = getParamVal(request, "insurancePurchasesHowMuch");

            BaoXianView baoXianView = new BaoXianView();
            baoXianView.setCompany(insurancePurchasesCompany);
            baoXianView.setOrder_num(insurancePurchasesNum);
            baoXianView.setOrder_time(insurancePurchasesTime);
            baoXianView.setHow_much(insurancePurchasesHowMuch);

            person.setInsurancePurchases(new Gson().toJson(baoXianView));

            int roleType = (person.getType() == 0 ? 5 : person.getType());
            //施工人员
            person.setRoleName(DicUtil.getValueByKeyAndFlag(roleType, "roles"));
            person.setRolePermission(DicUtil.getValueByKeyAndFlag(roleType, "permissions"));
            personService.savePerson(person, getLoginUser());
        } catch (Exception e) {
            return DWZResponseUtil.callbackFail("300", "保存失败", "_blank");
        }
        return DWZResponseUtil.callbackSuccess("保存成功", "_blank");
    }

    @ResponseBody
    @RequestMapping(value = "/batch_delete", method = RequestMethod.POST)
    public DWZResponse batchdeletePerson(Model model, HttpServletRequest request) {
        try {
            String ids = getParamVal(request, "ids");
            List<String> idList = DicUtil.splitWithOutNull(ids);
            for (String id : idList) {
                try {
                    deletePerson(model, Integer.parseInt(id));
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
    public DWZResponse deletePerson(Model model, @PathVariable("id") int id) {
        try {
            Person person = new Person();
            person.setId(id);
            personService.deletePerson(person);
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
            String fileName = "施工人员导入模板.xlsx";
            String anno = "注释：橙色字段为必填项\n" +
                    "1.保险信息格式：保险公司,保险单号,保险额度,保险期限;" +
                    "必须按照该格式填写，若该项没有则填无，例如：泰康人寿,无,1000元,已到期";

            new ExportExcel("施工人员导入模板", Person.class, 2, 50, anno, 1).setDataList(new ArrayList()).write(response, fileName).dispose();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //施工人员导入页面
    @RequestMapping("/pop/upload")
    public String popUpload(Model model, HttpServletRequest request) {
        return "person/pop/uploadPerson";
    }

    //导入人员库数据页面提交
    @ResponseBody
    @RequestMapping(value = "/import/save", method = RequestMethod.POST)
    public DWZResponse importExcel(@RequestParam(value = "file") MultipartFile file) throws Exception {
        Long begin = System.currentTimeMillis();

        ImportExcel importExcel = new ImportExcel(file, 2, 0);
        List<Person> list = importExcel.getDataList(Person.class, 1);
        UserView loginUser = getLoginUser();
        for (Person person : list) {
            try {
                List<String> baoXianList = DicUtil.splitWithOutNull(person.getInsurancePurchases());
                if (null != baoXianList && baoXianList.size() > 0) {
                    BaoXianView baoXianView = new BaoXianView();
                    ;
                    try {
                        baoXianView.setCompany(baoXianList.get(0));
                        baoXianView.setOrder_num(baoXianList.get(1));
                        baoXianView.setHow_much(baoXianList.get(2));
                        baoXianView.setOrder_time(baoXianList.get(3));
                    } catch (Exception e) {
                        //有的人员没有这些信息
                    }

                    person.setInsurancePurchases(new Gson().toJson(baoXianView));
                }

                String typeName = person.getTypeName();
                int roleType = DicUtil.getKeyByValueAndFlag(typeName, "personType");
                roleType = (roleType == 0 ? 5 : roleType);

                person.setType(roleType);
                person.setRoleName(DicUtil.getValueByKeyAndFlag(roleType, "roles"));
                person.setRolePermission(DicUtil.getValueByKeyAndFlag(roleType, "permissions"));
                //先循环入库吧，到时候定了再加个批量插入
                personService.savePerson(person, loginUser);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }

        Long end = System.currentTimeMillis();
        return DWZResponseUtil.callbackSuccess("导入成功，耗时" + (end - begin) / 1000 + "秒", "_blank");

    }

}
