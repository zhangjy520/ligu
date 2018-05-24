package cc.ligu.mvc.service;
import cc.ligu.mvc.persistence.entity.Question;
import cc.ligu.mvc.persistence.entity.User;

import java.util.List;
import java.util.Map;

public interface QuestionService {

	int saveQuestion(Question question);

	Question selectQuestionByPrimery(int questionId);

	int deleteQuestion(Question question);
}
