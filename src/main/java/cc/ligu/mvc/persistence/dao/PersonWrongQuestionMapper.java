package cc.ligu.mvc.persistence.dao;

import cc.ligu.mvc.persistence.entity.PersonWrongQuestion;
import cc.ligu.mvc.persistence.entity.PersonWrongQuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonWrongQuestionMapper {
    int deleteByExample(PersonWrongQuestionExample example);

    int insert(PersonWrongQuestion record);

    int insertSelective(PersonWrongQuestion record);

    List<PersonWrongQuestion> selectByExample(PersonWrongQuestionExample example);

    int updateByExampleSelective(@Param("record") PersonWrongQuestion record, @Param("example") PersonWrongQuestionExample example);

    int updateByExample(@Param("record") PersonWrongQuestion record, @Param("example") PersonWrongQuestionExample example);
}