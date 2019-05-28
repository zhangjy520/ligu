package cc.ligu.mvc.service;

import cc.ligu.mvc.persistence.entity.*;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;


public interface ProjectInfoService {
    PageInfo<ProjectInfo> listAllProjectInfo(int pageSize, int pageNum, ProjectInfo projectInfo);

    int saveProjectInfo(ProjectInfo projectInfo, UserView userView);

    ProjectInfo selectProjectInfoByPrimary(int projectInfoId);

    int deleteProjectInfo(ProjectInfo projectInfo);

    int batchDeleteProjectInfo(List projectIdList);

    //获取工程信息的级联json
    Map selectProjectDropDownJson();

    int saveProjectCheck(ProjectCheck projectCheck);

    Map projectCheckReport(String area, String projectYear, String companyUnit,
                                   String profession, String status,String projectName);

    Map getQueryConditions();

    List<Map> xunJianReport();
}
