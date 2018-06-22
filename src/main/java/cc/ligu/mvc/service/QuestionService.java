package cc.ligu.mvc.service;

import cc.ligu.mvc.persistence.entity.PersonExamHistory;
import cc.ligu.mvc.persistence.entity.PersonExamHistoryWithBLOBs;
import cc.ligu.mvc.persistence.entity.Question;
import cc.ligu.mvc.persistence.entity.UserView;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface QuestionService {
    PageInfo<Question> listAllQuestion(int pageSize, int pageNum, Question question);

    int saveQuestion(Question question, UserView userView);

    Question selectQuestionByPrimary(int questionId);

    int deleteQuestion(Question question);

    List<Map> selectRandomQuestionByCount(int count);

    int saveExam(PersonExamHistoryWithBLOBs personExamHistoryWithBLOBs);

    PersonExamHistoryWithBLOBs getExamById(int examId);

    List<Question> getQuestionListByIds(String ids);

    int saveWrongExam(String json) throws Exception;
}
