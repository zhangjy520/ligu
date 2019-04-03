package cc.ligu.mvc.persistence.dao;

import cc.ligu.mvc.persistence.entity.RefPersonExam;
import cc.ligu.mvc.persistence.entity.RefPersonExamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RefPersonExamMapper {
    int deleteByExample(RefPersonExamExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RefPersonExam record);

    int insertSelective(RefPersonExam record);

    List<RefPersonExam> selectByExample(RefPersonExamExample example);

    RefPersonExam selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RefPersonExam record, @Param("example") RefPersonExamExample example);

    int updateByExample(@Param("record") RefPersonExam record, @Param("example") RefPersonExamExample example);

    int updateByPrimaryKeySelective(RefPersonExam record);

    int updateByPrimaryKey(RefPersonExam record);
}