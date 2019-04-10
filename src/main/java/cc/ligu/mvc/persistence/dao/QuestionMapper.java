package cc.ligu.mvc.persistence.dao;

import cc.ligu.mvc.persistence.entity.Question;
import cc.ligu.mvc.persistence.entity.QuestionExample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface QuestionMapper {
    int deleteByExample(QuestionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Question record);

    int insertSelective(Question record);

    List<Question> selectByExample(QuestionExample example);

    Question selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Question record, @Param("example") QuestionExample example);

    int updateByExample(@Param("record") Question record, @Param("example") QuestionExample example);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

    List<Question> selectRandomQuestionByCount(@Param("count") int count);

    //随机查询答案长度不超过20个字符的单选题
    List<Question> selectPvpRandomQuestionByCount(@Param("count") int count);

    //重置指定人员的最新积分为0,段位也重置为了最低为1
    int resetJiFenByPersonId(Integer personId);

    //查询某次考试的人的列表分数
    List<HashMap> selectExamPersonListByExamId(Integer examId);
    //查询某个人参加的所有考试的得分情况
    List<HashMap> selectPersonScoreListByPersonId(Integer personId);
    //查询每次考试的每个人的名次
    List<HashMap> selectAllMingCi();
}