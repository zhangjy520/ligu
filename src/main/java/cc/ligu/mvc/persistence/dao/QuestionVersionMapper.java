package cc.ligu.mvc.persistence.dao;

import cc.ligu.mvc.persistence.entity.QuestionVersion;
import cc.ligu.mvc.persistence.entity.QuestionVersionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestionVersionMapper {
    int deleteByExample(QuestionVersionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(QuestionVersion record);

    int insertSelective(QuestionVersion record);

    List<QuestionVersion> selectByExample(QuestionVersionExample example);

    QuestionVersion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QuestionVersion record, @Param("example") QuestionVersionExample example);

    int updateByExample(@Param("record") QuestionVersion record, @Param("example") QuestionVersionExample example);

    int updateByPrimaryKeySelective(QuestionVersion record);

    int updateByPrimaryKey(QuestionVersion record);
}