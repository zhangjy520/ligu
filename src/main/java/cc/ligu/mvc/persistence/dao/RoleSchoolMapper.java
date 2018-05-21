package cc.ligu.mvc.persistence.dao;

import cc.ligu.mvc.persistence.entity.RoleSchool;
import cc.ligu.mvc.persistence.entity.RoleSchoolExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleSchoolMapper {
    int deleteByExample(RoleSchoolExample example);

    int insert(RoleSchool record);

    int insertSelective(RoleSchool record);

    List<RoleSchool> selectByExample(RoleSchoolExample example);

    int updateByExampleSelective(@Param("record") RoleSchool record, @Param("example") RoleSchoolExample example);

    int updateByExample(@Param("record") RoleSchool record, @Param("example") RoleSchoolExample example);
}