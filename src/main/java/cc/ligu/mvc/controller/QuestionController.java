/**
 * Created by zjy on 2018/5/20.
 * 题库管理（题库增删改+导入）
 */
package cc.ligu.mvc.controller;

import cc.ligu.common.controller.BasicController;
import cc.ligu.common.utils.DWZResponseUtil;
import cc.ligu.common.utils.excel.ExportExcel;
import cc.ligu.common.utils.excel.ImportExcel;
import cc.ligu.mvc.modelView.DWZResponse;
import cc.ligu.mvc.persistence.entity.Question;
import cc.ligu.mvc.service.QuestionService;
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

@RequestMapping("/question")
@Controller
public class QuestionController extends BasicController {

    @Autowired
    QuestionService questionService;

    @RequestMapping(value = "/index")
    public String questionIndex(HttpServletRequest request, Model model) {
        String content = getParamVal(request, "content");
        Question question = new Question();
        question.setContent(content);
        PageInfo<Question> pageInfo = questionService.listAllQuestion(getPageSize(request), getPageNum(request), question);
        model.addAttribute("pageInfo", pageInfo);

        model.addAttribute("chooseContent", content);
        return "question/index";
    }

    @RequestMapping("/pop/modify")
    public String popAdd(Model model, HttpServletRequest request) {
        String id = getParamVal(request, "id");
        if (!StringUtils.isEmpty(id)) {
            Question question = questionService.selectQuestionByPrimery(Integer.parseInt(id));
            model.addAttribute("question", question);
        }
        return "question/pop/editQuestion";
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public DWZResponse saveQuestion(Model model, Question question) {
        try {
            questionService.saveQuestion(question);
        } catch (Exception e) {
            return DWZResponseUtil.callbackFail("500", "保存题目失败", "");
        }
        return DWZResponseUtil.callbackSuccess("保存题目成功", "_blank");
    }


    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public DWZResponse deleteQuestion(Model model, @PathVariable("id") int id) {
        try {
            Question question = new Question();
            question.setId(id);
            questionService.deleteQuestion(question);
        } catch (Exception e) {
            return DWZResponseUtil.callbackFail("500", "删除题目失败", "");
        }
        return DWZResponseUtil.callbackSuccess("删除题目成功", "");
    }

    //问题库模版下载
    @ResponseBody
    @RequestMapping(value = "/template/download")
    public void exportMoban(HttpServletResponse response) {
        try {
            String fileName = "问题库导入模板.xlsx";
            String anno = "注释：橙色字段为必填项\n" +
                    "1.若题目答案为多选，格式参考：A,B,C";

            new ExportExcel("问题库导入模板", Question.class, 2, 50, anno, 1).setDataList(new ArrayList()).write(response, fileName).dispose();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //题库导入页面
    @RequestMapping("/pop/upload")
    public String popUpload(Model model, HttpServletRequest request) {
        return "question/pop/uploadQuestion";
    }

    //导入问题库数据页面提交
    @ResponseBody
    @RequestMapping(value = "/import/save", method = RequestMethod.POST)
    public DWZResponse importExcel(@RequestParam(value = "file") MultipartFile file) throws Exception {
        Long begin = System.currentTimeMillis();

        ImportExcel importExcel = new ImportExcel(file, 2, 0);
        List<Question> list = importExcel.getDataList(Question.class, 1);

        for (Question question : list) {
            try {
                //先循环入库吧，到时候定了再加个批量插入
                questionService.saveQuestion(question);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }

        Long end = System.currentTimeMillis();

        return DWZResponseUtil.callbackSuccess("导入成功，耗时" + (end - begin) / 1000 + "秒", "_blank");

    }
}
