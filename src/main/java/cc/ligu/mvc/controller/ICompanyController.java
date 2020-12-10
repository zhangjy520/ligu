/**
 * Created by zjy on 2018/5/20.
 * 文档管理（文档增删改）
 */
package cc.ligu.mvc.controller;

import cc.ligu.common.controller.BasicController;
import cc.ligu.common.utils.DWZResponseUtil;
import cc.ligu.mvc.modelView.DWZResponse;
import cc.ligu.mvc.persistence.entity.InsuranceCompany;
import cc.ligu.mvc.service.ICompanyService;
import cc.ligu.mvc.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "/iCompany")
@Controller
public class ICompanyController extends BasicController {

    @Resource
    ICompanyService iCompanyService;

    @Resource
    UserService userService;

    @RequestMapping(value = "/index")
    public String icompanyIndex(HttpServletRequest request, Model model) {
        String name = getParamVal(request, "name");//名称模糊查询

        InsuranceCompany insuranceCompany = new InsuranceCompany();
        insuranceCompany.setName(name);

        PageInfo<InsuranceCompany> pageInfo = iCompanyService.listAllInsuranceCompany(getPageSize(request), getPageNum(request), insuranceCompany);

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("chooseName", name);
        return "icompany/index";
    }

    @RequestMapping("/pop/modify")
    public String popAdd(Model model, HttpServletRequest request) {
        String id = getParamVal(request, "id");
        if (!StringUtils.isEmpty(id)) {
            InsuranceCompany insuranceCompany = iCompanyService.selectInsuranceCompanyByPrimary(Integer.parseInt(id));
            model.addAttribute("insuranceCompany", insuranceCompany);
        }
        return "icompany/pop/editIcompany";
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public DWZResponse saveItem(HttpServletRequest request, Model model, InsuranceCompany insuranceCompany) {
        try {
            iCompanyService.saveInsuranceCompany(insuranceCompany);
        } catch (Exception e) {
            return DWZResponseUtil.callbackFail("300", "保存失败", "");
        }
        return DWZResponseUtil.callbackSuccess("保存成功", "_blank");
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public DWZResponse deleteIcompany(Model model, @PathVariable("id") int id) {
        try {
            InsuranceCompany insuranceCompany = new InsuranceCompany();
            insuranceCompany.setId(id);
            iCompanyService.deleteInsuranceCompany(insuranceCompany);
        } catch (Exception e) {
            return DWZResponseUtil.callbackFail("300", "删除失败", "");
        }
        return DWZResponseUtil.callbackSuccess("删除成功", "");
    }
}
