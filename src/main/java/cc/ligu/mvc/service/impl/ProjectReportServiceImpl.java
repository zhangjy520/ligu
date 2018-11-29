package cc.ligu.mvc.service.impl;

import cc.ligu.common.service.BasicService;
import cc.ligu.common.utils.DicUtil;
import cc.ligu.mvc.persistence.dao.ProjectReportMapper;
import cc.ligu.mvc.persistence.entity.ProjectReport;
import cc.ligu.mvc.persistence.entity.ProjectReportExample;
import cc.ligu.mvc.persistence.entity.UserView;
import cc.ligu.mvc.service.ProjectReportService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by zjy on 2018/5/21.
 */
@Service
public class ProjectReportServiceImpl extends BasicService implements ProjectReportService {

    @Autowired
    ProjectReportMapper projectReportMapper;

    @Override
    public PageInfo<ProjectReport> listAllProjectReport(int pageSize, int pageNum, ProjectReport projectReport) {
        ProjectReportExample example = new ProjectReportExample();
        example.createCriteria().andIdIsNotNull();

        PageHelper.startPage(pageNum, pageSize);
        List<ProjectReport> reportList = projectReportMapper.selectByExample(example);
        for (ProjectReport project : reportList) {
            if (!StringUtils.isEmpty(project.getProjectAttach())){
                project.setAttchList(DicUtil.splitWithOutNull(project.getProjectAttach()));
            }
            if (!StringUtils.isEmpty(project.getProjectPic())){
                project.setPicList(DicUtil.splitWithOutNull(project.getProjectPic()));
            }
        }
        PageInfo<ProjectReport> page = new PageInfo<ProjectReport>(reportList);

        return page;
    }

    @Override
    public int saveProjectReport(ProjectReport projectReport, UserView userView) {
        if (StringUtils.isEmpty(projectReport.getId())) {
            projectReport.setCreateBy(userView.getId());
            projectReport.setCreateDate(System.currentTimeMillis());
            projectReportMapper.insertSelective(projectReport);
        } else {
            projectReport.setUpdateBy(userView.getId());
            projectReport.setUpdateDate(System.currentTimeMillis());
            projectReportMapper.updateByPrimaryKeySelective(projectReport);
        }
        return 1;
    }

    @Override
    public ProjectReport selectProjectReportByPrimary(int projectReportId) {
        ProjectReport projectR =  projectReportMapper.selectByPrimaryKey(projectReportId);
        if (!StringUtils.isEmpty(projectR.getProjectAttach())){
            projectR.setAttchList(DicUtil.splitWithOutNull(projectR.getProjectAttach()));
        }
        if (!StringUtils.isEmpty(projectR.getProjectPic())){
            projectR.setPicList(DicUtil.splitWithOutNull(projectR.getProjectPic()));
        }
        return projectR;
    }

    @Override
    public List<ProjectReport> projectReportList(ProjectReport projectReport) {
        ProjectReportExample example = new ProjectReportExample();
        ProjectReportExample.Criteria cri = example.createCriteria();

        return projectReportMapper.selectByExample(example);
    }

    @Override
    public int deleteProjectReport(int keyId) {
        return projectReportMapper.deleteByPrimaryKey(keyId);
    }
}
