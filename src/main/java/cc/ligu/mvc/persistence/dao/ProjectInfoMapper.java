package cc.ligu.mvc.persistence.dao;

import cc.ligu.mvc.persistence.entity.ProjectInfo;
import cc.ligu.mvc.persistence.entity.ProjectInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectInfoMapper {
    int deleteByExample(ProjectInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectInfo record);

    int insertSelective(ProjectInfo record);

    List<ProjectInfo> selectByExample(ProjectInfoExample example);

    ProjectInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectInfo record, @Param("example") ProjectInfoExample example);

    int updateByExample(@Param("record") ProjectInfo record, @Param("example") ProjectInfoExample example);

    int updateByPrimaryKeySelective(ProjectInfo record);

    int updateByPrimaryKey(ProjectInfo record);
}