package cc.ligu.mvc.persistence.dao;

import cc.ligu.mvc.persistence.entity.PersonSalary;
import cc.ligu.mvc.persistence.entity.PersonSalaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonSalaryMapper {
    int deleteByExample(PersonSalaryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PersonSalary record);

    int insertSelective(PersonSalary record);

    List<PersonSalary> selectByExample(PersonSalaryExample example);

    PersonSalary selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PersonSalary record, @Param("example") PersonSalaryExample example);

    int updateByExample(@Param("record") PersonSalary record, @Param("example") PersonSalaryExample example);

    int updateByPrimaryKeySelective(PersonSalary record);

    int updateByPrimaryKey(PersonSalary record);
}