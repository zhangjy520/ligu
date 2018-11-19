package cc.ligu.mvc.persistence.dao;

import cc.ligu.mvc.persistence.entity.ProjectReport;
import cc.ligu.mvc.persistence.entity.ProjectReportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectReportMapper {
    int deleteByExample(ProjectReportExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectReport record);

    int insertSelective(ProjectReport record);

    List<ProjectReport> selectByExample(ProjectReportExample example);

    ProjectReport selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectReport record, @Param("example") ProjectReportExample example);

    int updateByExample(@Param("record") ProjectReport record, @Param("example") ProjectReportExample example);

    int updateByPrimaryKeySelective(ProjectReport record);

    int updateByPrimaryKey(ProjectReport record);
}