package cn.gukeer.classcard.service;

import cn.gukeer.classcard.modelView.ClassCardCustomPageView;
import cn.gukeer.classcard.persistence.entity.ClassCardCustomPage;
import cn.gukeer.common.entity.ResultEntity;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ClassCardCustomPageService {

    PageInfo<ClassCardCustomPageView> findAllPageBySchoolId(String schoolId, int pageNum, int pageSize);

    PageInfo<ClassCardCustomPageView> findAllPageByUser(String userId, String schoolId, int pageNum,int pageSize);

    PageInfo<ClassCardCustomPageView> findAllConfigByClassCardIds(List<String>classCardIds,String userId, int pageNum, int pageSize);

    List<ClassCardCustomPageView> transformPage(List<ClassCardCustomPageView> pageViews);

    Integer deletePageById(String id);

    Integer insertPage(ClassCardCustomPage customPage);

    Integer updatePage(ClassCardCustomPage customPage);

    ClassCardCustomPage findOneById(String pageId);

    //根据id查询并且status = 1,已发布的page
    ClassCardCustomPage findOneReleaseById(String pageId,int status);

    ClassCardCustomPageView findViewOneById(String pageId);

    Boolean verifyReleaseDate(String classCardList,String loopMark,String loopDate,Long startTime,Long endTime);

    List<ClassCardCustomPageView> findCustomPageListByIds(List<String> classcardPageIds);

    ResultEntity deletePage(String customPageIds);

}
