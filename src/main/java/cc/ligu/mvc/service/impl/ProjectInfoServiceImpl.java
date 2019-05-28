package cc.ligu.mvc.service.impl;

import cc.ligu.common.service.BasicService;
import cc.ligu.common.utils.DateUtils;
import cc.ligu.common.utils.DicUtil;
import cc.ligu.mvc.modelView.MessageView;
import cc.ligu.mvc.modelView.PvpPersonView;
import cc.ligu.mvc.modelView.ScoreView;
import cc.ligu.mvc.persistence.dao.*;
import cc.ligu.mvc.persistence.entity.*;
import cc.ligu.mvc.service.ProjectInfoService;
import cc.ligu.mvc.service.QuestionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zjy on 2018/5/21.
 */
@Service
public class ProjectInfoServiceImpl extends BasicService implements ProjectInfoService {

    @Autowired
    ProjectInfoMapper projectInfoMapper;
    @Autowired
    ProjectCheckMapper projectCheckMapper;

    @Override
    public PageInfo<ProjectInfo> listAllProjectInfo(int pageSize, int pageNum, ProjectInfo projectInfo) {
        ProjectInfoExample projectInfoExample = new ProjectInfoExample();
        ProjectInfoExample.Criteria criteria = projectInfoExample.createCriteria();


        PageHelper.startPage(pageNum, pageSize);
        List<ProjectInfo> questionList = projectInfoMapper.selectByExample(projectInfoExample);
        PageInfo<ProjectInfo> page = new PageInfo<ProjectInfo>(questionList);
        return page;
    }

    @Override
    public int saveProjectInfo(ProjectInfo projectInfo, UserView userView) {
        //防止重复导入。参数一致，更新
        ProjectInfoExample example = new ProjectInfoExample();
        example.createCriteria().
                andAreaEqualTo(projectInfo.getArea()).andProjectYearEqualTo(projectInfo.getProjectYear()).
                andCompanyUnitEqualTo(projectInfo.getCompanyUnit()).andProfessionEqualTo(projectInfo.getProfession()).
                andProjectNameEqualTo(projectInfo.getProjectName());
        List<ProjectInfo> re = projectInfoMapper.selectByExample(example);
        if (re.size() > 0) {
            return 0;//参数一致的信息不再录入了。
        }

        if (StringUtils.isEmpty(projectInfo.getId())) {
            projectInfo.setCreateBy(userView.getId());//创建人
            projectInfo.setCreateDate(System.currentTimeMillis());//创建时间
            projectInfoMapper.insertSelective(projectInfo);
        } else {
            projectInfo.setUpdateDate(System.currentTimeMillis());
            projectInfo.setUpdateBy(userView.getId());
            projectInfoMapper.updateByPrimaryKeySelective(projectInfo);
        }
        return 1;
    }

    @Override
    public ProjectInfo selectProjectInfoByPrimary(int projectInfoId) {
        return projectInfoMapper.selectByPrimaryKey(projectInfoId);
    }

    @Override
    public int deleteProjectInfo(ProjectInfo projectInfo) {
        return projectInfoMapper.deleteByPrimaryKey(projectInfo.getId());
    }

    @Override
    public int batchDeleteProjectInfo(List projectIdList) {
        if (projectIdList.size() > 0) {
            ProjectInfoExample example = new ProjectInfoExample();
            example.createCriteria().andIdIn(projectIdList);

            return projectInfoMapper.deleteByExample(example);
        }
        return 0;
    }

    @Override
    public Map selectProjectDropDownJson() {
        ProjectInfoExample projectExample = new ProjectInfoExample();
        projectExample.createCriteria();
        List<ProjectInfo> res = projectInfoMapper.selectByExample(projectExample);
        try {
            Map json = toLianDong(res);
            return json;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int saveProjectCheck(ProjectCheck projectCheck) {
        //巡检积分以后要解析 projectCheck.getCheckPerson()
        if (StringUtils.isEmpty(projectCheck.getId())) {
            return projectCheckMapper.insertSelective(projectCheck);
        } else {
            return projectCheckMapper.updateByPrimaryKeySelective(projectCheck);
        }
    }

    @Override
    public Map projectCheckReport(String area, String projectYear, String companyUnit, String profession, String status,String projectName) {
        Map resView = new HashMap();
        List<Map> res = projectCheckMapper.projectCheckReport(area, projectYear, companyUnit, profession, status,projectName);
        if (res.size() > 0) {
            int over = 0;//完成
            int modi = 0;//在建
            int ing = 0;//进行
            for (Map map : res) {
                map.put("local_pics", DicUtil.splitWithOutNull(map.get("local_pics").toString()));
                over += Integer.parseInt(map.get("over").toString());
                modi += Integer.parseInt(map.get("modi").toString());
                ing += Integer.parseInt(map.get("ing").toString());
                try {
                    map.put("check_person", JSONObject.fromObject(map.get("check_person")));
                }catch (Exception e){

                }
            }
            resView.put("over",over);
            resView.put("modi",modi);
            resView.put("ing",ing);
            resView.put("data",res);
        }
        return resView;
    }

    @Override
    public Map getQueryConditions() {
        List<String> areaList = projectCheckMapper.getAreaConditions();
        List<String> companyUnitList = projectCheckMapper.getCompanyUnitConditions();
        List<String> professionList = projectCheckMapper.getProfessionConditions();
        List<String> projectYearList = projectCheckMapper.getProjectYearConditions();
        List<String> statusList = DicUtil.splitWithOutNull("在建,整改,完成");
        Map res = new HashMap();
        res.put("areaList",areaList);
        res.put("companyUnitList",companyUnitList);
        res.put("professionList",professionList);
        res.put("projectYearList",projectYearList);
        res.put("statusList",statusList);
        return res;
    }


    public Map toLianDong(List<ProjectInfo> param) throws Exception{
        Map<Object, Map<Object, Map<Object, Map<Object, List<Map<String, String>>>>>> m = new HashMap();
        for (ProjectInfo projectInfo : param) {
            String area = projectInfo.getArea();
            String profession = projectInfo.getProfession();
            String project_year = projectInfo.getProjectYear();
            String company_unit = projectInfo.getCompanyUnit();
            String project_name = projectInfo.getProjectName();
            int projectId = projectInfo.getId();

            Map<Object, Map<Object, Map<Object, List<Map<String, String>>>>> areaMap = m.get(area);
            if (areaMap != null) {
                Map<Object, Map<Object, List<Map<String, String>>>> yearMap = areaMap.get(project_year);
                if (yearMap != null) {
                    Map<Object, List<Map<String, String>>> company_unitMap = yearMap.get(company_unit);
                    if (company_unitMap != null) {
                        List<Map<String, String>> professionList = company_unitMap.get(profession);
                        if (professionList != null) {
                            Map detail = new HashMap();
                            detail.put("projectName", project_name);
                            detail.put("projectId", projectId);
                            professionList.add(detail);
                        } else {
                            List<Map<String, String>> project_nameList = new ArrayList<>();
                            Map detail = new HashMap();
                            detail.put("projectName", project_name);
                            detail.put("projectId", projectId);
                            project_nameList.add(detail);
                            company_unitMap.put(profession, project_nameList);
                        }
                    } else {
                        Map<Object, List<Map<String, String>>> newMap = new HashMap<>();
                        List<Map<String, String>> project_nameList = new ArrayList<>();
                        Map detail = new HashMap();
                        detail.put("projectName", project_name);
                        detail.put("projectId", projectId);
                        project_nameList.add(detail);
                        newMap.put(profession, project_nameList);
                        yearMap.put(company_unit, newMap);
                    }
                } else {
                    Map<Object, Map<Object, List<Map<String, String>>>> newYearMap = new HashMap<>();
                    Map<Object, List<Map<String, String>>> newMap = new HashMap<>();
                    List<Map<String, String>> project_nameList = new ArrayList<>();
                    Map detail = new HashMap();
                    detail.put("projectName", project_name);
                    detail.put("projectId", projectId);
                    project_nameList.add(detail);
                    newMap.put(profession, project_nameList);
                    newYearMap.put(company_unit, newMap);
                    areaMap.put(project_year, newYearMap);
                }
            } else {
                Map<Object, Map<Object, Map<Object, List<Map<String, String>>>>> newAreMap = new HashMap<>();
                Map<Object, Map<Object, List<Map<String, String>>>> newYearMap = new HashMap<>();
                Map<Object, List<Map<String, String>>> newMap = new HashMap<>();
                List<Map<String, String>> project_nameList = new ArrayList<>();
                Map detail = new HashMap();
                detail.put("projectName", project_name);
                detail.put("projectId", projectId);
                project_nameList.add(detail);
                newMap.put(profession, project_nameList);
                newYearMap.put(company_unit, newMap);
                newAreMap.put(project_year, newYearMap);
                m.put(area, newAreMap);
            }

        }
        return m;
    }
}
