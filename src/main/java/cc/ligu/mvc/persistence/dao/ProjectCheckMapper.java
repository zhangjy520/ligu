package cc.ligu.mvc.persistence.dao;

import cc.ligu.mvc.persistence.entity.ProjectCheck;
import cc.ligu.mvc.persistence.entity.ProjectCheckExample;

import java.util.List;
import java.util.Map;

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

    List<Map> projectCheckReport(@Param("area") String area, @Param("projectYear") String projectYear, @Param("companyUnit") String companyUnit,
                                 @Param("profession") String profession, @Param("status") String status, @Param("projectName") String projectName);

    List<String> getAreaConditions();

    List<String> getProjectYearConditions();

    List<String> getCompanyUnitConditions();

    List<String> getProfessionConditions();
    List<Map> xunJianReport();
}