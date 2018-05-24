package cc.ligu.mvc.controller;

import cc.ligu.common.controller.BasicController;
import cc.ligu.common.utils.DWZResponseUtil;
import cc.ligu.mvc.modelView.DWZResponse;
import cc.ligu.mvc.persistence.entity.Question;
import cc.ligu.mvc.service.QuestionService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/question")
@Controller
public class QuestionController extends BasicController {

    @Autowired
    QuestionService questionService;

    @RequestMapping(value = "/index")
    public String toLogin(HttpServletRequest request, Model model) {
        PageInfo<Question> pageInfo = questionService.listAllQuestion(getPageSize(request),getPageNum(request));
        model.addAttribute("pageInfo", pageInfo);
        return "question/index";
    }

    @RequestMapping("/pop/add")
    public String popAdd(Model model) {
        return "question/pop/editQuestion";
    }

    @ResponseBody
    @RequestMapping(value ="/delete/{id}",method = RequestMethod.POST)
    public DWZResponse deleteQuestion(Model model, @PathVariable("id") int id) {
        try {
            Question question = new Question();
            question.setId(id);
            questionService.deleteQuestion(question);
        } catch (Exception e) {
            return DWZResponseUtil.callbackFail("500","删除用户失败");
        }
        return DWZResponseUtil.callbackSuccess("删除用户成功");
    }
}
