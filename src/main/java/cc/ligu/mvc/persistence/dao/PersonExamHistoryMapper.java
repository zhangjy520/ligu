package cc.ligu.mvc.persistence.dao;

import cc.ligu.mvc.persistence.entity.PersonExamHistory;
import cc.ligu.mvc.persistence.entity.PersonExamHistoryExample;
import cc.ligu.mvc.persistence.entity.PersonExamHistoryWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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
}