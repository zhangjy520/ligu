package cc.ligu.mvc.service;

import cc.ligu.mvc.persistence.entity.ProjectReport;
import cc.ligu.mvc.persistence.entity.UserView;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ProjectReportService {
    PageInfo<ProjectReport> listAllProjectReport(int pageSize, int pageNum, ProjectReport projectReport);

    int saveProjectReport(ProjectReport projectReport, UserView userView);

    ProjectReport selectProjectReportByPrimary(int projectReportId);

    List<ProjectReport> projectReportList(ProjectReport projectReport);

    int deleteProjectReport(int keyId);//根据主键删除

}
