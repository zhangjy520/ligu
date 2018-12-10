package cc.ligu.mvc.persistence.dao;

import cc.ligu.mvc.persistence.entity.PersonExamHistory;
import cc.ligu.mvc.persistence.entity.PersonExamHistoryExample;
import cc.ligu.mvc.persistence.entity.PersonExamHistoryWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PersonExamHistoryMapper {
    int deleteByExample(PersonExamHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PersonExamHistoryWithBLOBs record);

    int insertSelective(PersonExamHistoryWithBLOBs record);

    List<PersonExamHistoryWithBLOBs> selectByExampleWithBLOBs(PersonExamHistoryExample example);

    List<PersonExamHistory> selectByExample(PersonExamHistoryExample example);

    PersonExamHistoryWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PersonExamHistoryWithBLOBs record, @Param("example") PersonExamHistoryExample example);

    int updateByExampleWithBLOBs(@Param("record") PersonExamHistoryWithBLOBs record, @Param("example") PersonExamHistoryExample example);

    int updateByExample(@Param("record") PersonExamHistory record, @Param("example") PersonExamHistoryExample example);

    int updateByPrimaryKeySelective(PersonExamHistoryWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PersonExamHistoryWithBLOBs record);

    int updateByPrimaryKey(PersonExamHistory record);

    List<PersonExamHistoryWithBLOBs> getExamReport(@Param("examTime")String examTime,@Param("examType")int examType);

    List<Map> listAllHaveScorePerson();

    List<Map> exportAllScore();
}