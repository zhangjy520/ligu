package cn.gukeer.classcard.service.impl;

import cn.gukeer.classcard.modelView.ClassCardAppView;
import cn.gukeer.classcard.modelView.ClassCardView;
import cn.gukeer.classcard.persistence.dao.A_ClassCardAppMapper;
import cn.gukeer.classcard.persistence.dao.ClassCardAppMapper;
import cn.gukeer.classcard.persistence.dao.ClassCardAppRefMapper;
import cn.gukeer.classcard.persistence.entity.*;
import cn.gukeer.classcard.service.ClassCardAppService;
import cn.gukeer.classcard.util.ApkFeedBackStatus;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alpha on 18-1-9.
 */
@Service
public class ClassCardAppServiceImpl implements ClassCardAppService {


    @Autowired
    ClassCardAppMapper classCardAppMapper;

    @Autowired
    A_ClassCardAppMapper a_classCardAppMapper;

    @Autowired
    ClassCardAppRefMapper classCardAppRefMapper;

    @Override
    public PageInfo<ClassCardAppView> findAllClassCardApp(String schoolId, String appName, int pageNum, int pageSize) {
        if (pageSize != -1) {
            PageHelper.startPage(pageNum, pageSize);
        }
        ClassCardAppExample example = new ClassCardAppExample();
        example.createCriteria().andDelFlagEqualTo(0);
        example.setOrderByClause("update_date desc");
        List<ClassCardAppView> classCardAppViews = a_classCardAppMapper.findAllClassCardAppView(schoolId, appName);
        PageInfo<ClassCardAppView> pageInfo = new PageInfo<>(classCardAppViews);
        return pageInfo;
    }

    @Override
    public boolean insertClassCardApp(ClassCardApp classCardApp) {
        boolean flag = false;
        int count = classCardAppMapper.insertSelective(classCardApp);
        if (count == 1) {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean updateClassCardApp(ClassCardApp classCardApp) {
        boolean flag = false;
        int count = classCardAppMapper.updateByPrimaryKeySelective(classCardApp);
        if (count == 1) {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean deleteClassCardApp(List<String> appIds) {

        if (appIds == null || appIds.size() == 0) {
            return false;
        }
        boolean flag = false;
        ClassCardAppExample example = new ClassCardAppExample();
        example.createCriteria().andIdIn(appIds);
        ClassCardApp classCardApp = new ClassCardApp();
        classCardApp.setDelFlag(1);
        int count = 0;
        count = classCardAppMapper.updateByExampleSelective(classCardApp, example);

        if (count == appIds.size()) {
            flag = true;
        }

        return flag;
    }

    @Override
    public ClassCardApp findClassCardAppById(String id) {
        ClassCardApp classCardApp = classCardAppMapper.selectByPrimaryKey(id);
        return classCardApp != null ? classCardApp : new ClassCardApp();
    }

    @Override
    public ClassCardAppRef findRefByClassCardIdAndAppId(String classCardId, String classCardAppId) {
        ClassCardAppRefExample example = new ClassCardAppRefExample();
        example.createCriteria().andClassCardIdEqualTo(classCardId).andClassCardAppIdEqualTo(classCardAppId);
        List<ClassCardAppRef> appRefs = classCardAppRefMapper.selectByExample(example);
        ClassCardAppRef classCardAppRef = null;
        if (appRefs != null && appRefs.size() > 0) {
            classCardAppRef = appRefs.get(0);
        }
        return classCardAppRef;
    }

    @Override
    public int batchInsertClassCardAppRef(List<ClassCardAppRef> classCardAppRefs) {
        int count = a_classCardAppMapper.batchInsertClassCardAppRef(classCardAppRefs);
        return count;
    }

    @Override
    public List<ClassCardAppRef> findRefByClassCardId(String classCardId) {
        List<Integer> statusList=new ArrayList<>();
        statusList.add(ApkFeedBackStatus.APK_FEED_BACK_STATUS_SUCCESS.getIndex());
        statusList.add(ApkFeedBackStatus.APK_FEED_BACK_STATUS_INSTALLED.getIndex());

        ClassCardAppRefExample example = new ClassCardAppRefExample();
        example.createCriteria().andClassCardIdEqualTo((classCardId)).andFeedBackStatusIn(statusList);
        List<ClassCardAppRef> classCardAppRefs = classCardAppRefMapper.selectByExample(example);
        return classCardAppRefs;
    }

    @Override
    public List<ClassCardAppRef> findRefByAppId(String appId) {
        ClassCardAppRefExample example = new ClassCardAppRefExample();
        example.createCriteria().andClassCardAppIdEqualTo(appId);
        List<ClassCardAppRef> classCardAppRefs = classCardAppRefMapper.selectByExample(example);
        return classCardAppRefs;
    }

    @Override
    public List<ClassCardApp> findAppByIds(List<String> ids) {
        ClassCardAppExample example = new ClassCardAppExample();
        example.createCriteria().andIdIn(ids);
        example.setOrderByClause("app_name");
        List<ClassCardApp> classCardApps = classCardAppMapper.selectByExample(example);
        return classCardApps;
    }

    @Override
    public boolean deleteClassCardAppRef(String classCardId, String appId) {
        boolean flag = false;
        ClassCardAppRefExample example = new ClassCardAppRefExample();
        example.createCriteria().andClassCardIdEqualTo(classCardId).andClassCardAppIdEqualTo(appId);
        int count = classCardAppRefMapper.deleteByExample(example);
        if (count == 1) {
            flag = true;
        }
        return flag;
    }

    @Override
    public ClassCardApp findAppByName(String appName, String schoolId) {
        ClassCardAppExample example = new ClassCardAppExample();
        example.createCriteria().andAppNameEqualTo(appName).andDelFlagEqualTo(0).andSchoolIdEqualTo(schoolId);
        List<ClassCardApp> classCardApps = classCardAppMapper.selectByExample(example);
        ClassCardApp classCardApp = null;
        if (classCardApps != null && classCardApps.size() > 0) {
            classCardApp = classCardApps.get(0);
        }
        return classCardApp;
    }

    @Override
    public ClassCardApp findAppByPackageName(String packageName, String schoolId) {
        ClassCardAppExample example = new ClassCardAppExample();
        example.createCriteria().andPackageNameEqualTo(packageName).andDelFlagEqualTo(0).andSchoolIdEqualTo(schoolId);
        List<ClassCardApp> classCardApps = classCardAppMapper.selectByExample(example);
        ClassCardApp classCardApp = null;
        if (classCardApps != null && classCardApps.size() > 0) {
            classCardApp = classCardApps.get(0);
        }
        return classCardApp;
    }

    @Override
    public List<ClassCardView> findClassCardByappId(String appId, String schoolId) {
        //显示50个安装记录
        PageHelper.startPage(0,50);
        List<ClassCardView> classCards = a_classCardAppMapper.findClassCardByappId(schoolId, appId);

        return classCards;
    }

    @Override
    public boolean insertClassCardAppRef(ClassCardAppRef classCardAppRef) {
        boolean flag = false;
        int count = classCardAppRefMapper.insertSelective(classCardAppRef);
        if (count == 1) {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean updateClassCardAppRef(ClassCardAppRef classCardAppRef) {
        boolean flag = false;
        ClassCardAppRefExample example = new ClassCardAppRefExample();
        example.createCriteria().andClassCardIdEqualTo(classCardAppRef.getClassCardId()).
                andClassCardAppIdEqualTo(classCardAppRef.getClassCardAppId());
        int count = classCardAppRefMapper.updateByExampleSelective(classCardAppRef, example);
        if (count == 1) {
            flag = true;
        }
        return flag;
    }
}
