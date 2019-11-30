/**
 * Created by zjy on 2018/5/20.
 * 题库管理（题库增删改+导入）
 */
package cc.ligu.mvc.controller;

import cc.ligu.common.controller.BasicController;
import cc.ligu.common.utils.DWZResponseUtil;
import cc.ligu.common.utils.DateUtils;
import cc.ligu.common.utils.DicUtil;
import cc.ligu.common.utils.excel.ExportExcel;
import cc.ligu.common.utils.excel.ImportExcel;
import cc.ligu.mvc.modelView.DWZResponse;
import cc.ligu.mvc.persistence.entity.*;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

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
            Question question = questionService.selectQuestionByPrimary(Integer.parseInt(id));
            model.addAttribute("question", question);
        }
        return "question/pop/editQuestion";
    }

    @RequestMapping("/pop/sendExam")
    public String examSend(Model model, HttpServletRequest request) {
        return "question/pop/sendExam";
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public DWZResponse saveQuestion(Model model, Question question) {
        try {
            questionService.saveQuestion(question, getLoginUser());
        } catch (Exception e) {
            return DWZResponseUtil.callbackFail("300", "保存题目失败", "");
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
            return DWZResponseUtil.callbackFail("300", "删除题目失败", "");
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
        UserView loginUser = getLoginUser();
        for (Question question : list) {
            try {
                //先循环入库吧，到时候定了再加个批量插入
                questionService.saveQuestion(question, loginUser);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }

        Long end = System.currentTimeMillis();

        return DWZResponseUtil.callbackSuccess("导入成功，耗时" + (end - begin) / 1000 + "秒", "_blank");

    }


    //考试成绩统计
    @RequestMapping(value = "/score")
    public String scoreIndex(HttpServletRequest request, Model model) {
        PageInfo<Map> pageInfo = questionService.listAllHaveScorePerson(getPageSize(request), getPageNum(request));
        model.addAttribute("pageInfo", pageInfo);
        return "question/personScoreList";
    }

    //获取某人的历史成绩
    @RequestMapping("/score/{id}")
    public String scoreDetailIndex(HttpServletRequest request, Model model, @PathVariable("id") int personId) {
        String personName = getParamVal(request, "personName");
        UserView view = new UserView();
        view.setRefId(personId);

        List<PersonExamHistoryWithBLOBs> result = questionService.getHistoryScore(view);
        for (PersonExamHistoryWithBLOBs format : result) {
            format.setExamTime(DateUtils.millsToDate(format.getExamTime(), "yyyy-MM-dd HH:mm"));
        }

        model.addAttribute("personName", personName);
        model.addAttribute("data", result);
        return "question/pop/scoreDetail";
    }

    @ResponseBody
    @RequestMapping(value = "/batch_delete", method = RequestMethod.POST)
    public DWZResponse batchdeletePerson(Model model, HttpServletRequest request) {
        try {
            String ids = getParamVal(request, "ids");
            List<String> idList = DicUtil.splitWithOutNull(ids);

            if (idList.size() > 0) {
                questionService.deletePersonScore(idList);
            }
        } catch (Exception e) {
            return DWZResponseUtil.callbackFail("300", "删除失败", "_blank");
        }
        return DWZResponseUtil.callbackSuccess("删除成功", "_blank");
    }

    //导出功能
    @ResponseBody
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void exportFile(HttpServletRequest request, HttpServletResponse response) {
        try {
            String fileName = "历史考试成绩导出.xlsx";
            List<Map> scoreList = questionService.exportAllScore();

            List<PersonExamHistory> dataList = new ArrayList<>();
            if (scoreList.size() > 0) {
                for (Map map : scoreList) {
                    try {
                        PersonExamHistory scoreHistory = new PersonExamHistory();
                        scoreHistory.setPersonName(map.get("name").toString());
                        scoreHistory.setPersonIdCard(map.get("identity_num").toString());
                        scoreHistory.setExamTime(DateUtils.millsToDate(map.get("exam_time").toString(), "yyyy-MM-dd HH:mm"));
                        scoreHistory.setObtainScore(map.get("obtain_score").toString());

                        dataList.add(scoreHistory);
                    } catch (Exception e) {
                        continue;
                    }
                }

            }

            new ExportExcel("历史考试成绩导出", PersonExamHistory.class, 1, 50, null, 1).setDataList(dataList).write(response, fileName).dispose();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //发布考试
    @ResponseBody
    @RequestMapping(value = "/saveExam", method = RequestMethod.GET)
    public void saveExam(){
        Calendar cale = Calendar.getInstance();
        // 获取当月第一天和最后一天
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        // 获取前月的第一天
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        long firstday = cale.getTimeInMillis();

        // 获取前月的最后一天
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        long lastday = cale.getTimeInMillis();

        UserView userView = getLoginUser();
        List<Question> res = questionService.selectRandomQuestionByCount(40);
        StringBuffer buffer = new StringBuffer();
        for (Question question :res) {
            buffer.append(","+question.getId());
        }
        ExamNotice examNotice = new ExamNotice();
        examNotice.setExamName((cale.get(Calendar.MONTH)+1)+"月模拟考试");
        examNotice.setDateBegin(String.valueOf(firstday));
        examNotice.setDateEnd(String.valueOf(lastday));
        examNotice.setQuestionIds(buffer.toString());
        questionService.saveExamNotice(examNotice,userView);
    }


    //导出功能
    @ResponseBody
    @RequestMapping(value = "/questionExport", method = RequestMethod.GET)
    public void exportQuestionFile(HttpServletRequest request, HttpServletResponse response) {
        try {
            String fileName = "题库导出数据.xlsx";
            PageInfo<Question> dataList = questionService.listAllQuestion(Integer.MAX_VALUE, 1, new Question());

            String anno = "导出的模板：题目类别，题目难度为数字，意思如下：\n" +
                    "题目类别：1：单选题,2：多选题,3：其他\n" +
                    "题目难度：1：简单,2：一般,3：困难";

            new ExportExcel("题库导出数据", Question.class, 2, 50, anno, 1).setDataList(dataList.getList()).write(response, fileName).dispose();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
