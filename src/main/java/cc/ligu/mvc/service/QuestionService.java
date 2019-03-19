package cc.ligu.mvc.service;

import cc.ligu.mvc.modelView.PvpPersonView;
import cc.ligu.mvc.modelView.ScoreView;
import cc.ligu.mvc.persistence.entity.*;
import com.github.pagehelper.PageInfo;

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
    void uploadMachinePvpResult(Integer pvpId,UserView userViewA,Integer scoreA,Integer scoreMachine);

    //根据pvp的积分，匹配对应的成就
    PvpArchievement regexPvpArchieveByJiFen(Integer jiFen);

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
    PvpPersonView selectLatestPvpByPersonAId(String personAId);
}
