package cc.ligu.mvc.service;

import cc.ligu.mvc.persistence.entity.Question;
import cc.ligu.mvc.persistence.entity.UserView;
import com.github.pagehelper.PageInfo;

public interface QuestionService {
    PageInfo<Question> listAllQuestion(int pageSize, int pageNum, Question question);

    int saveQuestion(Question question, UserView userView);

    Question selectQuestionByPrimary(int questionId);

    int deleteQuestion(Question question);
}
