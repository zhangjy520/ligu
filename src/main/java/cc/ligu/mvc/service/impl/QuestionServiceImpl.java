package cc.ligu.mvc.service.impl;

import cc.ligu.common.service.BasicService;
import cc.ligu.common.utils.DicUtil;
import cc.ligu.mvc.persistence.dao.PersonExamHistoryMapper;
import cc.ligu.mvc.persistence.dao.PersonWrongQuestionMapper;
import cc.ligu.mvc.persistence.dao.QuestionMapper;
import cc.ligu.mvc.persistence.entity.*;
import cc.ligu.mvc.service.QuestionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zjy on 2018/5/21.
 */
@Service
public class QuestionServiceImpl extends BasicService implements QuestionService {

    @Autowired
    QuestionMapper questionMapper;

    @Autowired
    PersonExamHistoryMapper personExamHistoryMapper;

    @Autowired
    PersonWrongQuestionMapper personWrongQuestionMapper;

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

    @Override
    public int saveExam(PersonExamHistoryWithBLOBs personExamHistoryWithBLOBs) {
        personExamHistoryMapper.insertSelective(personExamHistoryWithBLOBs);
        return personExamHistoryWithBLOBs.getId();
    }

    @Override
    public PersonExamHistoryWithBLOBs getExamById(int examId) {
        return personExamHistoryMapper.selectByPrimaryKey(examId);
    }

    @Override
    public List<Question> getQuestionListByIds(String ids) {
        List<String> idList = DicUtil.splitWithOutNull(ids);
        if(idList.size()>0){
            List<Integer> idIntegerList = new ArrayList<>();
            for (String id :idList) {
                idIntegerList.add(Integer.valueOf(id));
            }
           QuestionExample example = new QuestionExample();
           example.createCriteria().andIdIn(idIntegerList);
           return questionMapper.selectByExample(example);
        }
        return null;
    }

    @Override
    @Transactional
    public int saveWrongExam(String json) throws Exception{
        JSONArray array = JSONArray.fromObject(json);
        List<PersonWrongQuestion> list = JSONArray.toList(array, PersonWrongQuestion.class);// 过时方法

        for (PersonWrongQuestion personWrongQuestion : list) {
            personWrongQuestionMapper.insertSelective(personWrongQuestion);
        }
        return 0;
    }
}
