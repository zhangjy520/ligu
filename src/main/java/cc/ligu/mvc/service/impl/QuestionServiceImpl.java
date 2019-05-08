package cc.ligu.mvc.service.impl;

import cc.ligu.common.service.BasicService;
import cc.ligu.common.utils.DateUtils;
import cc.ligu.common.utils.DicUtil;
import cc.ligu.mvc.modelView.MessageView;
import cc.ligu.mvc.modelView.PvpPersonView;
import cc.ligu.mvc.modelView.ScoreView;
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

    @Autowired
    PvpPersonMapper pvpPersonMapper;

    @Autowired
    PvpArchievementMapper pvpArchievementMapper;

    @Autowired
    ApiMapper apiMapper;

    @Autowired
    ExamNoticeMapper examNoticeMapper;
    @Autowired
    NoticeMessageMapper noticeMessageMapper;
    @Autowired
    RefPersonExamMapper refPersonExamMapper;

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
    public List<Question> selectRandomQuestionByCount(int count) {
        return questionMapper.selectRandomQuestionByCount(count);
    }

    @Override
    @Transactional
    public synchronized HashMap selectPvpRandomQuestionByCountAndSaveRecord(int count, UserView userViewA, UserView userViewB) {
        //随机查询答案长度不超过20个字符的单选题
        List<Question> questionList = questionMapper.selectPvpRandomQuestionByCount(count);
        StringBuilder questionIds = new StringBuilder();
        for (Question question : questionList) {
            questionIds.append(question.getId() + ",");
        }
        PvpPerson pvpPerson = new PvpPerson();
        pvpPerson.setPersonAId(userViewA.getRefId());
        pvpPerson.setQuestionIds(questionIds.toString());
        pvpPerson.setPvpTime(String.valueOf(System.currentTimeMillis()));

        //查询personA的最新成绩
        PvpPersonView result = pvpPersonMapper.selectLatestPvpByPersonAId(userViewA.getRefId());
        if (null != result) {
            pvpPerson.setPersonACurrentJifen(result.getPersonACurrentJifen());
            pvpPerson.setPersonAchievementId(result.getPersonAchievementId());
        }

        //并且记录对战信息 对战类型[0人机对战 1人人对战]
        if (userViewB == null) {
            //人机对战，对面是电脑
            pvpPerson.setPvpType(0);
        } else {
            //人人对战，对面不是电脑
            pvpPerson.setPvpType(1);
            pvpPerson.setPersonBId(userViewB.getRefId());
        }
        pvpPersonMapper.insertSelective(pvpPerson);//将本次对战记录保存(此记录在对战结束还会更新积分等级)
        HashMap map = new HashMap();
        map.put("pvpId", pvpPerson.getId());//对战ID
        map.put("questionList", questionList);//对战题目列表
        return map;
    }

    @Override
    @Transactional
    public synchronized int uploadMachinePvpResult(Integer pvpId, UserView userViewA, Integer scoreA, Integer scoreMachine) {
        int getJiFen = 0;
        PvpPerson pvpPerson = pvpPersonMapper.selectByPrimaryKey(pvpId);//根据对战ID获取当前人员的分数积分详情
        pvpPerson.setPersonAScore(scoreA.toString());
        pvpPerson.setPersonBScore(scoreMachine.toString());
        if (scoreA > scoreMachine) {
            //大于机器得分，获胜
            pvpPerson.setPersonAThisScore(DicUtil.WIN_INTEGRAL);
            pvpPerson.setPersonACurrentJifen(pvpPerson.getPersonACurrentJifen() + DicUtil.WIN_INTEGRAL);
            getJiFen = DicUtil.WIN_INTEGRAL;
        } else if (scoreA == scoreMachine) {
            //等于机器得分，平局
            pvpPerson.setPersonAThisScore(DicUtil.PING_INTEGRAL);
            pvpPerson.setPersonACurrentJifen(pvpPerson.getPersonACurrentJifen() + DicUtil.PING_INTEGRAL);
            getJiFen = DicUtil.PING_INTEGRAL;
        } else {
            //小于机器得分，输
            pvpPerson.setPersonAThisScore(DicUtil.LOSE_INTEGRAL);
            pvpPerson.setPersonACurrentJifen(pvpPerson.getPersonACurrentJifen() + DicUtil.LOSE_INTEGRAL);
            getJiFen = DicUtil.LOSE_INTEGRAL;
        }
        pvpPerson.setComplete(1);//对战完成

        //根据当前积分重新计算段位
        PvpArchievement arch = regexPvpArchieveByJiFen(pvpPerson.getPersonACurrentJifen());
        if (arch != null) {
            pvpPerson.setPersonAchievementId(arch.getId());
        }
        pvpPersonMapper.updateByPrimaryKeySelective(pvpPerson);
        return getJiFen;
    }

    @Override
    public PvpArchievement regexPvpArchieveByJiFen(Integer jiFen) {
        PvpArchievementExample example = new PvpArchievementExample();
        example.createCriteria().andMinScoreLessThanOrEqualTo(jiFen)
                .andMaxScoreGreaterThanOrEqualTo(jiFen);
        List<PvpArchievement> arch = pvpArchievementMapper.selectByExample(example);

        if (arch.size() > 0) {
            return arch.get(0);
        }
        return null;
    }

    @Override
    @Transactional
    public void resetJiFenByPersonIds(List<Integer> personIdList) {
        if (personIdList.size() > 0) {
            for (Integer personId : personIdList) {
                questionMapper.resetJiFenByPersonId(personId);
            }
        }
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
            for (String id : idList) {
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

        for (PersonWrongQuestion personWrongQuestion : list) {
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
        for (PersonWrongQuestion wrongQuestion : wrongList) {
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
        for (String questionId : questionIdList) {
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
    @Transactional
    public int saveExamHistory(PersonExamHistoryWithBLOBs personExamHistory) {
        if (StringUtils.isEmpty(personExamHistory.getId())) {
            //TODO 保存考试成绩uploadExamResult
            //questionMapper.insertSelective(question);
            return 0;
        } else {
            personExamHistoryMapper.updateByPrimaryKeySelective(personExamHistory);

            PvpPerson score = selectLatestPvpByPersonAId(personExamHistory.getPersonId());//获取该人员的最新积分

            int getJiFen = calcJiFen(Integer.parseInt(personExamHistory.getObtainScore()));//计算该人员本次考试获取积分
            if (score!=null&&score.getPersonACurrentJifen()!=null){
                score.setPersonACurrentJifen(score.getPersonACurrentJifen() + getJiFen);//求和
                pvpPersonMapper.updateByPrimaryKeySelective(score);//更新
            }
            return getJiFen;
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
        for (PersonExamHistoryWithBLOBs bloBs : res) {

            calendar.setTimeInMillis(Long.valueOf(bloBs.getExamTime()));
            bloBs.setMonth(formatter.format(calendar.getTime()));
        }
        return res;
    }

    @Override
    public List<ScoreView> getMonthScoreList(int year, int month) {
        long begin = DicUtil.getBeginTime(year, month);
        long end = DicUtil.getEndTime(year, month);

        PersonExamHistoryExample examHistoryExample = new PersonExamHistoryExample();
        examHistoryExample.createCriteria().andExamTimeBetween(String.valueOf(begin), String.valueOf(end)).andObtainScoreIsNotNull().andExamTypeEqualTo(2);
        List<PersonExamHistoryWithBLOBs> bloBsList = personExamHistoryMapper.selectByExampleWithBLOBs(examHistoryExample);

        List<ScoreView> mapList = new ArrayList<>();
        for (PersonExamHistoryWithBLOBs bloBs : bloBsList) {
            Person person = personMapper.selectByPrimaryKey(bloBs.getPersonId());
            ScoreView re = new ScoreView();
            if (null != person) {
                re.setPersonName(person.getName());
                re.setPersonId(bloBs.getPersonId());
                re.setPersonIdentity(person.getIdentityNum());
            }
            re.setMonth(month);
            re.setScore(bloBs.getObtainScore());

            mapList.add(re);
        }
        //将同一人同月多次成绩排除低的
        List<ScoreView> resList = new ArrayList<>();
        for (ScoreView scoreView : mapList) {
            if (resList.contains(scoreView)) {//这里重写scoreView equals 方法，月份+身份证相同视为
                if (scoreView.getScore().compareTo(resList.get(resList.indexOf(scoreView)).getScore()) > 0) {
                    //如果当前的成绩大于已录入集合的成绩，刷新成绩
                    resList.get(resList.indexOf(scoreView)).setScore(scoreView.getScore());
                } else {
                    continue;
                }
            } else {
                resList.add(scoreView);
            }
        }
        Collections.sort(resList);
        for (int i = 0; i < resList.size(); i++) {
            resList.get(i).setOrder(i + 1);
        }
        return resList;

    }

    @Override
    public ScoreView personMonthScoreDetail(int personId, int year, int month) {
        List<ScoreView> res = getMonthScoreList(year, month);
        for (ScoreView scoreView : res) {
            if (scoreView.getPersonId() == personId) {
                return scoreView;
            }
        }
        return null;
    }

    @Override
    public Map getExamReport() {
        Date monthStart = doGetMonthStart(Calendar.getInstance());
        //获取当月考试的所有用户考试信息
        List<PersonExamHistoryWithBLOBs> monthExamResult = personExamHistoryMapper.getExamReport(String.valueOf(monthStart.getTime()), 2);

        List<PersonExamHistoryWithBLOBs> passList = new ArrayList<>();
        for (PersonExamHistoryWithBLOBs bloBs : monthExamResult) {
            if (!StringUtils.isEmpty(bloBs.getObtainScore())) {
                //分值不为空
                if (Integer.valueOf(bloBs.getObtainScore()) >= DicUtil.PASS_SCORE) {
                    //获得分数大于设定通过分数
                    passList.add(bloBs);
                }
            }
        }

        Map result = new HashMap();
        result.put("examUserS", monthExamResult.size());//参与考试的人数
        result.put("passUsers", passList.size());//当月通过考试的人数
        return result;
    }

    @Override
    public PageInfo<Map> listAllHaveScorePerson(int pageSize, int pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map> res = personExamHistoryMapper.listAllHaveScorePerson();

        PageInfo<Map> page = new PageInfo<Map>(res);
        return page;
    }

    @Override
    public int deletePersonScore(List personIdList) {
        if (personIdList.size() > 0) {
            PersonExamHistoryExample example = new PersonExamHistoryExample();
            example.createCriteria().andPersonIdIn(personIdList);

            return personExamHistoryMapper.deleteByExample(example);
        }
        return 0;
    }

    @Override
    public List<Map> exportAllScore() {
        return personExamHistoryMapper.exportAllScore();
    }

    @Override
    public PvpPersonView selectLatestPvpByPersonAId(Integer personAId) {
        return pvpPersonMapper.selectLatestPvpByPersonAId(personAId);
    }

    @Override
    public List<HashMap> selectLatestPvpList() {
        return pvpPersonMapper.selectLatestPvpList();
    }

    @Override
    @Transactional
    public int saveExamNotice(ExamNotice examNotice, UserView userView) {
        try {
            //1发布考试
            examNoticeMapper.insertSelective(examNotice);
            //2发布考试，要添加到消息表
            NoticeMessage noticeMessage = new NoticeMessage();
            noticeMessage.setRemark(userView.getName());
            noticeMessage.setType(MessageView.EXAM_NOTICE);
            noticeMessage.setNoticeTime(DateUtils.getYYYYMMDD());
            noticeMessage.setNoticeTo(0);
            noticeMessage.setNoticeFrom(userView.getRefId());
            noticeMessage.setTitle("考试通知");
            noticeMessage.setMessage(userView.getName() + "发布了考试：" + examNotice.getExamName());
            noticeMessage.setFlag(DateUtils.getYYYYMMDD() + "," + userView.getRefId() + "," + MessageView.EXAM_NOTICE);
            noticeMessageMapper.insertSelectiveDuUpdate(noticeMessage);

            //新增消息，要将考试类的考试主键保存
            NoticeMessage updateNoticeMessage = new NoticeMessage();
            updateNoticeMessage.setId(noticeMessage.getId());
            updateNoticeMessage.setRemark(noticeMessage.getRemark()+","+examNotice.getId());
            noticeMessageMapper.updateByPrimaryKeySelective(updateNoticeMessage);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public List<ExamNotice> selectAllExamNotice(UserView userView) {
        ExamNoticeExample examNoticeExample = new ExamNoticeExample();
        examNoticeExample.createCriteria().andDelFlagEqualTo(0);

        List<ExamNotice> examList = examNoticeMapper.selectByExample(examNoticeExample);
        for (ExamNotice notice : examList) {
            RefPersonExamExample examExample = new RefPersonExamExample();
            examExample.createCriteria().andPersonIdEqualTo(userView.getRefId())
                    .andExamIdEqualTo(notice.getId());
            List<RefPersonExam> res = refPersonExamMapper.selectByExample(examExample);
            notice.setDateBegin(DateUtils.millsToyyyyMMdd(Long.valueOf(notice.getDateBegin())));
            notice.setDateEnd(DateUtils.millsToyyyyMMdd(Long.valueOf(notice.getDateEnd())));
            if (res.size() > 0) {
                //通过考试ID和人员id查询有数据证明参加过考试
                notice.setIn(true);//参加过考试
            }

        }
        return examList;
    }

    @Override
    public Map inExamNotice(int personId, int examNoticeId) {
        Map map = new HashMap();
        //参加考试,返回考试题目列表
        ExamNotice examNotice = examNoticeMapper.selectByPrimaryKey(examNoticeId);
        examNotice.setDateBegin(DateUtils.millsToyyyyMMdd(Long.valueOf(examNotice.getDateBegin())));
        examNotice.setDateEnd(DateUtils.millsToyyyyMMdd(Long.valueOf(examNotice.getDateEnd())));

        List<Integer> questIdList = DicUtil.splitWithOutNullRetrunInt(examNotice.getQuestionIds());
        if (questIdList.size() > 0) {
            QuestionExample example = new QuestionExample();
            example.createCriteria().andIdIn(questIdList);
            List quesList = questionMapper.selectByExample(example);
            map.put("questionList", quesList);
        }
    //将参加考试的人，题目信息录入到考试记录中
        PersonExamHistoryWithBLOBs record = new PersonExamHistoryWithBLOBs();
        record.setPersonId(personId);
        record.setFullScore("100");
        record.setExamTime(String.valueOf(System.currentTimeMillis()));
        record.setExamType(3);//参加管理员发布的考试 1:平时练习,2:月份考试,3:管理员发布考试
        record.setQuestionIds(examNotice.getQuestionIds());
        saveExam(record);

        //参加管理员发布的考试
        RefPersonExam refPersonExam = new RefPersonExam();
        refPersonExam.setExamId(examNoticeId);
        refPersonExam.setExamTime(String.valueOf(System.currentTimeMillis()));
        refPersonExam.setPersonId(personId);
        refPersonExam.setRefHistoryExamId(record.getId());
        refPersonExamMapper.insertSelective(refPersonExam);

        examNotice.setId(record.getId());//将考试记录id给考试ID
        map.put("exam", examNotice);

        return map;
    }

    @Override
    public List<HashMap> getExamPersonListByExamId(int examNoticeId) {
        return questionMapper.selectExamPersonListByExamId(examNoticeId);
    }

    @Override
    public List<HashMap> getPersonScoreListByPersonId(int personId) {
        List<HashMap> mingci = questionMapper.selectAllMingCi();
        Map mingciMap = new HashMap();
        for (HashMap map : mingci) {
            mingciMap.put(map.get("id"),map.get("rank"));
        }

        List<HashMap> res = questionMapper.selectPersonScoreListByPersonId(personId);
        for (HashMap map : res) {
            Object rank = mingciMap.get(map.get("id"));
            map.put("rank",rank);
        }
        return res;
    }

    private static Date doGetMonthStart(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        return calendar.getTime();
    }

    //根据考试得到的分数，取得他对应的等级和对应形象
    //[90-100]5  [80-89]3 [70-79]2 [60-69]1 [0-60]0
    public static Integer calcJiFen(Integer score) {
        if (score >= 90 && score <= 100) {
            return 5;
        } else if (score >= 80 && score <= 89) {
            return 3;
        } else if (score >= 70 && score <= 79) {
            return 2;
        } else if (score >= 60 && score <= 69) {
            return 1;
        } else {
            return 0;
        }
    }
}
