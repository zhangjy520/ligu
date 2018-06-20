package cn.gukeer.classcard.service;

import cn.gukeer.classcard.persistence.entity.ClassCardCustomRef;

import java.util.List;

/**
 * Created by leeyh on 2018/1/18.
 */
public interface ClassCardCustomRefService {
    Integer deleteCustomRefById(String pageId);

    Integer updatePageRelease(String classCardList,String pageId);

    //参数delFlag,若为-1不进行delFlag字段的筛选，若为0/1添加delFlag = 0/1的条件
    String findCheckIds(String pageId,int delFlag);

    List<String> findPublishClasscardByPageId(String pageId);

    //查询该班牌已经发布的播放列表
    List<String> findIdListByClasscardId(String classcardId);

    Integer setDelFlagById(String pageId,String classcardList);

}
