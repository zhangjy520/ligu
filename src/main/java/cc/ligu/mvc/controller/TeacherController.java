package cc.ligu.mvc.controller;

import cc.ligu.common.controller.BasicController;
import cc.ligu.mvc.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by conn on 2016/8/8.
 * teacher
 */
@Controller
@RequestMapping(value = "/teacher")
public class TeacherController extends BasicController {

    @Autowired
    TeacherService teacherService;

    /**
     * 教师首页
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request, Model model) {

        return "t/teacherHome";
    }

}
