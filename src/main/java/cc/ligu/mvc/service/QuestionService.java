package cc.ligu.mvc.service;
import cc.ligu.mvc.persistence.entity.Question;
import cc.ligu.mvc.persistence.entity.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface QuestionService {
	PageInfo<Question> listAllQuestion(int pageSize, int pageNum);

	int saveQuestion(Question question);

	Question selectQuestionByPrimery(int questionId);

	int deleteQuestion(Question question);
}
