package cc.ligu.mvc.persistence.dao;

import cc.ligu.mvc.persistence.entity.ProjectCheck;
import cc.ligu.mvc.persistence.entity.ProjectCheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectCheckMapper {
    int deleteByExample(ProjectCheckExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectCheck record);

    int insertSelective(ProjectCheck record);

    List<ProjectCheck> selectByExample(ProjectCheckExample example);

    ProjectCheck selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectCheck record, @Param("example") ProjectCheckExample example);

    int updateByExample(@Param("record") ProjectCheck record, @Param("example") ProjectCheckExample example);

    int updateByPrimaryKeySelective(ProjectCheck record);

    int updateByPrimaryKey(ProjectCheck record);
}