package cc.ligu.mvc.controller;

import cc.ligu.common.controller.BasicController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by conn on 2016/8/1.
 * admin
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController extends BasicController {

    @RequestMapping(value = "/index")
    public String index() {
        return "m/xzHome";
    }

    @RequestMapping(value = "/baseStation")
    public String baseStation(HttpServletRequest request, Model model) {
        return "m/baseStation";
    }

    @RequestMapping(value = "/basicManage")
    public String basicManage(HttpServletRequest request, Model model) {
        return "m/basicManage";
    }

    @RequestMapping(value = "/blockManage")
    public String blockManage(HttpServletRequest request, Model model) {
        return "m/blockManage";
    }

    @RequestMapping(value = "/bodyHealth")
    public String bodyHealth(HttpServletRequest request, Model model) {
        return "m/bodyHealth";
    }

    @RequestMapping(value = "/classFiles")
    public String classFiles(HttpServletRequest request, Model model) {
        return "m/classFiles";
    }

    @RequestMapping(value = "/dailyData")
    public String dailyData(HttpServletRequest request, Model model) {
        return "m/dailyData";
    }

    @RequestMapping(value = "/dailyHealth")
    public String dailyHealth(HttpServletRequest request, Model model) {
        return "m/dailyHealth";
    }

    @RequestMapping(value = "/fileDetail")
    public String fileDetail(HttpServletRequest request, Model model) {
        return "m/fileDetail";
    }

    @RequestMapping(value = "/gradeManage")
    public String gradeManage(HttpServletRequest request, Model model) {
        return "m/gradeManage";
    }

    @RequestMapping(value = "/healthGuide")
    public String healthGuide(HttpServletRequest request, Model model) {
        return "m/healthGuide";
    }

    @RequestMapping(value = "/PEtest")
    public String PEtest(HttpServletRequest request, Model model) {
        return "m/P.E.test";
    }

    @RequestMapping(value = "/roleManage")
    public String roleManage(HttpServletRequest request, Model model) {
        return "m/roleManage";
    }

    @RequestMapping(value = "/shjk")
    public String shjk(HttpServletRequest request, Model model) {
        return "m/shjk";
    }

    @RequestMapping(value = "/shManage")
    public String shManage(HttpServletRequest request, Model model) {
        return "m/shManage";
    }

    @RequestMapping(value = "/shStock")
    public String shStock(HttpServletRequest request, Model model) {
        return "m/shStock";
    }

    @RequestMapping(value = "/studentFiles")
    public String studentFiles(HttpServletRequest request, Model model) {
        return "m/studentFiles";
    }

    @RequestMapping(value = "/teacherManage")
    public String teacherManage(HttpServletRequest request, Model model) {
        return "m/teacherManage";
    }

    @RequestMapping(value = "/temporarySH")
    public String temporarySH(HttpServletRequest request, Model model) {
        return "m/temporarySH";
    }

    @RequestMapping(value = "/xzHome")
    public String xzHome
            (HttpServletRequest request, Model model) {
        return "m/xzHome";
    }
}