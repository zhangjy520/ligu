package cc.ligu.mvc.service;

import cc.ligu.mvc.persistence.entity.*;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface ProjectInfoService {
    PageInfo<ProjectInfo> listAllProjectInfo(int pageSize, int pageNum, ProjectInfo projectInfo);

    int saveProjectInfo(ProjectInfo projectInfo, UserView userView);

    ProjectInfo selectProjectInfoByPrimary(int projectInfoId);

    int deleteProjectInfo(ProjectInfo projectInfo);

    int batchDeleteProjectInfo(List projectIdList);

    //获取工程信息的级联json
    String selectProjectDropDownJson();

    int saveProjectCheck(ProjectCheck projectCheck);
}
