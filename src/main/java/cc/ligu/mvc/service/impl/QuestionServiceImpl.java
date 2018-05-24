package cc.ligu.mvc.service.impl;

import cc.ligu.common.service.BasicService;
import cc.ligu.common.utils.Constants;
import cc.ligu.mvc.persistence.dao.QuestionMapper;
import cc.ligu.mvc.persistence.dao.UserMapper;
import cc.ligu.mvc.persistence.entity.Question;
import cc.ligu.mvc.persistence.entity.QuestionExample;
import cc.ligu.mvc.persistence.entity.User;
import cc.ligu.mvc.persistence.entity.UserExample;
import cc.ligu.mvc.service.QuestionService;
import cc.ligu.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by zjy on 2018/5/21.
 */
@Service
public class QuestionServiceImpl extends BasicService implements QuestionService {

    @Autowired
    QuestionMapper questionMapper;


    @Override
    public int saveQuestion(Question question) {
        if(StringUtils.isEmpty(question.getId())){
            questionMapper.insertSelective(question);
        }else {
            questionMapper.updateByPrimaryKeySelective(question);
        }
        return 1;
    }

    @Override
    public Question selectQuestionByPrimery(int questionId) {
        return questionMapper.selectByPrimaryKey(questionId);
    }

    @Override
    public int deleteQuestion(Question question) {
        questionMapper.deleteByPrimaryKey(question.getId());
        return 1;
    }
}
