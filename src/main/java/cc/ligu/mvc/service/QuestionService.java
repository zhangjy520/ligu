package cc.ligu.mvc.service;

import cc.ligu.mvc.modelView.PvpPersonView;
import cc.ligu.mvc.modelView.ScoreView;
import cc.ligu.mvc.persistence.entity.*;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.crypto.hash.Hash;

import java.util.HashMap;
import java.util.Map;

import java.util.List;

public interface QuestionService {
    PageInfo<Question> listAllQuestion(int pageSize, int pageNum, Question question);

    int saveQuestion(Question question, UserView userView);

    Question selectQuestionByPrimary(int questionId);

    int deleteQuestion(Question question);

    List<Question> selectRandomQuestionByCount(int count);

    //随机查询答案长度不超过20个字符的单选题,并且记录对战信息
    HashMap selectPvpRandomQuestionByCountAndSaveRecord(int count, UserView userViewA, UserView userViewB);

    //人机对战完毕，上传人机对战结果，后期如果有人人对战需求，另外设计表吧
    int uploadMachinePvpResult(Integer pvpId,UserView userViewA,Integer scoreA,Integer scoreMachine);

    //根据pvp的积分，匹配对应的成就
    PvpArchievement regexPvpArchieveByJiFen(Integer jiFen);

    //重置一批人的积分
    void resetJiFenByPersonIds(List<Integer> personIdList);

    int saveExam(PersonExamHistoryWithBLOBs personExamHistoryWithBLOBs);

    PersonExamHistoryWithBLOBs getExamById(int examId);

    List<Question> getQuestionListByIds(String ids);

    int saveWrongExam(String json, UserView userView) throws Exception;

    int saveWrongQuestion(PersonWrongQuestion personWrongQuestion) throws Exception;

    List<Question> wrongQuestionList(int personId);

    int removeWrongQuestion(String questionIds, int personId);

    QuestionVersion selectVersion();

    int saveExamHistory(PersonExamHistoryWithBLOBs personExamHistory);

    List<PersonExamHistoryWithBLOBs> getHistoryScore(UserView userView);

    List<ScoreView> getMonthScoreList(int year, int month);

    ScoreView personMonthScoreDetail(int personId, int year, int month);

    Map getExamReport();

    PageInfo<Map> listAllHaveScorePerson(int pageSize, int pageNum);//查询当前参加了考试的人员列表

    int deletePersonScore(List personIdList);//删除某个人的历史考试成绩

    List<Map> exportAllScore();//查询所有的考试成绩

    //获取指定人员当前的段位，积分(取最新的对战成绩即可)
    PvpPersonView selectLatestPvpByPersonAId(Integer personAId);

    //获取最新积分排行(积分从高到低排列)
    List<HashMap> selectLatestPvpList();

    //发布考试
    int saveExamNotice(ExamNotice examNotice,UserView userView);

    //获取所有考试列表
    List<ExamNotice> selectAllExamNotice(UserView userView);

    //参加考试(返回考试信息，和考试题目列表)
    Map inExamNotice(int personId,int examNoticeId);

    //根据examId获取此次考试的人员列表和分数情况
    List<HashMap> getExamPersonListByExamId(int examNoticeId);
    //查询某个人参加的所有考试的得分情况
    List<HashMap> getPersonScoreListByPersonId(int personId);
}
