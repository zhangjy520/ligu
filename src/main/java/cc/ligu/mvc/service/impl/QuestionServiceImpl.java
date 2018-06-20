package cc.ligu.mvc.service.impl;

import cc.ligu.common.service.BasicService;
import cc.ligu.mvc.persistence.dao.QuestionMapper;
import cc.ligu.mvc.persistence.entity.Question;
import cc.ligu.mvc.persistence.entity.QuestionExample;
import cc.ligu.mvc.persistence.entity.UserView;
import cc.ligu.mvc.service.QuestionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by zjy on 2018/5/21.
 */
@Service
public class QuestionServiceImpl extends BasicService implements QuestionService {

    @Autowired
    QuestionMapper questionMapper;


    @Override
    public PageInfo<Question> listAllQuestion(int pageSize, int pageNum, Question question) {
        QuestionExample questionExample = new QuestionExample();
        QuestionExample.Criteria criteria = questionExample.createCriteria().andDelFlagEqualTo(0);

        if (!StringUtils.isEmpty(question.getContent())) {
            criteria.andContentLike("%" + question.getContent() + "%");
        }

        PageHelper.startPage(pageNum, pageSize);
        List<Question> questionList = questionMapper.selectByExample(questionExample);
        PageInfo<Question> page = new PageInfo<Question>(questionList);
        return page;
    }

    @Override
    public int saveQuestion(Question question, UserView userView) {
        if (StringUtils.isEmpty(question.getId())) {
            question.setCreateBy(userView.getId());//创建人
            question.setCreateDate(System.currentTimeMillis());//创建时间
            questionMapper.insertSelective(question);
        } else {
            question.setUpdateDate(System.currentTimeMillis());
            question.setUpdateBy(userView.getId());
            questionMapper.updateByPrimaryKeySelective(question);
        }
        return 1;
    }

    @Override
    public Question selectQuestionByPrimary(int questionId) {
        return questionMapper.selectByPrimaryKey(questionId);
    }

    @Override
    public int deleteQuestion(Question question) {
        return questionMapper.deleteByPrimaryKey(question.getId());
    }

    @Override
    public List<Map> selectRandomQuestionByCount(int count) {
        return questionMapper.selectRandomQuestionByCount(count);
    }
}
