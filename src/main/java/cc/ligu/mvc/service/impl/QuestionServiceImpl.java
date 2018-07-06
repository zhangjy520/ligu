package cc.ligu.mvc.service.impl;

import cc.ligu.common.service.BasicService;
import cc.ligu.common.utils.DicUtil;
import cc.ligu.mvc.persistence.dao.*;
import cc.ligu.mvc.persistence.entity.*;
import cc.ligu.mvc.service.QuestionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zjy on 2018/5/21.
 */
@Service
public class QuestionServiceImpl extends BasicService implements QuestionService {

    @Autowired
    QuestionMapper questionMapper;

    @Autowired
    PersonMapper personMapper;

    @Autowired
    PersonExamHistoryMapper personExamHistoryMapper;

    @Autowired
    PersonWrongQuestionMapper personWrongQuestionMapper;

    @Autowired
    QuestionVersionMapper questionVersionMapper;

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


        List<QuestionVersion> versionList = questionVersionMapper.selectByExample(new QuestionVersionExample());
        if (versionList.size() > 0) {
            QuestionVersion questionVersion = versionList.get(0);
            questionVersion.setVersion(questionVersion.getVersion() + 1);
            questionVersion.setUpdateTime(System.currentTimeMillis());
            questionVersion.setUpdateBy(userView.getId());
            questionVersion.setUpdateUserName(userView.getName());

            questionVersionMapper.updateByPrimaryKeySelective(questionVersion);
        } else {
            //如果题库版本号不存在，新增一个默认题库版本号
            QuestionVersion defaultVersion = new QuestionVersion();
            defaultVersion.setVersion(1);
            defaultVersion.setUpdateTime(System.currentTimeMillis());
            defaultVersion.setUpdateBy(userView.getId());
            defaultVersion.setUpdateUserName(userView.getName());

            questionVersionMapper.insertSelective(defaultVersion);
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
        if (idList.size() > 0) {
            List<Integer> idIntegerList = new ArrayList<>();
            for (String id: idList) {
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
    public int saveWrongExam(String json, UserView userView) throws Exception {
        JSONArray array = JSONArray.fromObject(json);
        List<PersonWrongQuestion> list = JSONArray.toList(array, PersonWrongQuestion.class);// 过时方法

        for (PersonWrongQuestion personWrongQuestion: list) {
            personWrongQuestion.setPersonId(userView.getRefId());
            personWrongQuestionMapper.insertSelective(personWrongQuestion);
        }
        return 0;
    }

    @Override
    public int saveWrongQuestion(PersonWrongQuestion personWrongQuestion) throws Exception {
        return personWrongQuestionMapper.insertSelective(personWrongQuestion);
    }

    @Override
    public List<Question> wrongQuestionList(int personId) {
        PersonWrongQuestionExample example = new PersonWrongQuestionExample();
        example.createCriteria().andPersonIdEqualTo(personId);

        List<PersonWrongQuestion> wrongList = personWrongQuestionMapper.selectByExample(example);
        List<Integer> questionIdList = new ArrayList<>();
        for (PersonWrongQuestion wrongQuestion: wrongList) {
            questionIdList.add(wrongQuestion.getQuestionId());
        }
        if (questionIdList.size() > 0) {
            QuestionExample quExample = new QuestionExample();
            quExample.createCriteria().andIdIn(questionIdList);
            return questionMapper.selectByExample(quExample);
        } else {
            return null;
        }
    }

    @Override
    public int removeWrongQuestion(String questionIds, int personId) {
        List<String> questionIdList = DicUtil.splitWithOutNull(questionIds);
        for (String questionId: questionIdList) {
            PersonWrongQuestionExample example = new PersonWrongQuestionExample();
            example.createCriteria().andPersonIdEqualTo(personId).andQuestionIdEqualTo(Integer.valueOf(questionId));
            personWrongQuestionMapper.deleteByExample(example);
        }
        return 1;
    }

    @Override
    public QuestionVersion selectVersion() {
        List<QuestionVersion> questionVersion = questionVersionMapper.selectByExample(new QuestionVersionExample());
        if (questionVersion.size() > 0) {
            return questionVersion.get(0);
        } else {
            return new QuestionVersion();
        }
    }

    @Override
    public int saveExamHistory(PersonExamHistoryWithBLOBs personExamHistory) {
        if (StringUtils.isEmpty(personExamHistory.getId())) {
            //TODO 保存考试成绩
            //questionMapper.insertSelective(question);
            return 1;
        } else {
            return personExamHistoryMapper.updateByPrimaryKeySelective(personExamHistory);
        }
    }

    @Override
    public List<PersonExamHistoryWithBLOBs> getHistoryScore(UserView userView) {
        PersonExamHistoryExample examHistoryExample = new PersonExamHistoryExample();
        examHistoryExample.setOrderByClause("exam_time");
        examHistoryExample.createCriteria().andPersonIdEqualTo(userView.getRefId()).andObtainScoreIsNotNull().andExamTypeEqualTo(2);//该人成绩不为空的数据记录

        List<PersonExamHistoryWithBLOBs> res = personExamHistoryMapper.selectByExampleWithBLOBs(examHistoryExample);
        DateFormat formatter = new SimpleDateFormat("MM");
        Calendar calendar = Calendar.getInstance();
        for (PersonExamHistoryWithBLOBs bloBs: res) {

            calendar.setTimeInMillis(Long.valueOf(bloBs.getExamTime()));
            bloBs.setMonth(formatter.format(calendar.getTime()));
        }
        return res;
    }

    @Override
    public List<Map> getMonthScoreList(int year, int month) {
        long begin = DicUtil.getBeginTime(year, month);
        long end = DicUtil.getEndTime(year, month);

        PersonExamHistoryExample examHistoryExample = new PersonExamHistoryExample();
        examHistoryExample.setOrderByClause("obtain_score DESC");
        examHistoryExample.createCriteria().andExamTimeBetween(String.valueOf(begin), String.valueOf(end)).andObtainScoreIsNotNull().andExamTypeEqualTo(2);
        List<PersonExamHistoryWithBLOBs> bloBsList = personExamHistoryMapper.selectByExampleWithBLOBs(examHistoryExample);

        List<Map> mapList = new ArrayList<>();
        for (PersonExamHistoryWithBLOBs bloBs: bloBsList) {
            Person person = personMapper.selectByPrimaryKey(bloBs.getPersonId());
            Map re = new HashMap();
            re.put("person", person.getName());
            re.put("score", bloBs.getObtainScore());

            mapList.add(re);
        }

        return mapList;

    }


}
