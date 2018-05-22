package cn.gukeer.classcard.service.impl;


import cn.gukeer.classcard.persistence.dao.ClassCardCustomRefMapper;
import cn.gukeer.classcard.persistence.entity.ClassCardCustomRef;
import cn.gukeer.classcard.persistence.entity.ClassCardCustomRefExample;
import cn.gukeer.classcard.service.ClassCardCustomRefService;
import cn.gukeer.common.utils.PrimaryKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leeyh on 2018/1/18.
 */

@Service
public class ClassCardCustomRefServiceImpl implements ClassCardCustomRefService {

    @Autowired
    ClassCardCustomRefMapper customRefMapper;

    @Override
    public Integer deleteCustomRefById(String pageId) {
        ClassCardCustomRefExample example = new ClassCardCustomRefExample();
        example.createCriteria().andPageIdEqualTo(pageId);
        return customRefMapper.deleteByExample(example);
    }

    @Override
    public Integer updatePageRelease(String classCardList, String pageId) {
        int count = 0;
        String[] classCards = classCardList.split(",");
        deleteCustomRefById(pageId);
        for (int i = 0; i < classCards.length; i++) {
            ClassCardCustomRef customRef = new ClassCardCustomRef();
            customRef.setId(PrimaryKey.get());
            customRef.setPageId(pageId);
            customRef.setClassCardId(classCards[i]);
            count += customRefMapper.insertSelective(customRef);
        }
        return count;
    }

    /**
     * 查询自定义界面发布的设备，拼接为string返回，用逗号分隔
     * @param pageId
     * @return
     */
    @Override
    public String findCheckIds(String pageId,int delFlag) {
        String checkIds = "";
        ClassCardCustomRefExample example = new ClassCardCustomRefExample();
        ClassCardCustomRefExample.Criteria criteria = example.createCriteria();
        criteria.andPageIdEqualTo(pageId);
        if (delFlag != -1) {
            criteria.andDelFlagEqualTo(delFlag);
        }
        List<ClassCardCustomRef> customRefs = customRefMapper.selectByExample(example);
        for (ClassCardCustomRef customRef : customRefs) {
            checkIds += customRef.getClassCardId() + ",";
        }
        return checkIds;
    }

    @Override
    public List<String> findPublishClasscardByPageId(String pageId) {
        ClassCardCustomRefExample example = new ClassCardCustomRefExample();
        example.createCriteria().andPageIdEqualTo(pageId).andDelFlagEqualTo(0);
        List<String> publishClasscardList = new ArrayList<>();
        List<ClassCardCustomRef> classCardCustomRefs = customRefMapper.selectByExample(example);
        for (ClassCardCustomRef classCardCustomRef:classCardCustomRefs) {
            publishClasscardList.add(classCardCustomRef.getClassCardId());
        }
        return publishClasscardList;
    }

    @Override
    public List<String> findIdListByClasscardId(String classcardId) {
        ClassCardCustomRefExample example = new ClassCardCustomRefExample();
        example.createCriteria().andClassCardIdEqualTo(classcardId).andDelFlagEqualTo(0);
        List<ClassCardCustomRef> customRefServices = customRefMapper.selectByExample(example);

        List<String> classcardPageIds = new ArrayList<>();
        for (ClassCardCustomRef classCardCustomRef : customRefServices) {
            classcardPageIds.add(classCardCustomRef.getPageId());
        }
        return classcardPageIds;
    }

    @Override
    public Integer setDelFlagById(String pageId,String classcardList) {
        String[] classcardIds = classcardList.split(",");
        ClassCardCustomRef classCardCustomRef = new ClassCardCustomRef();
        classCardCustomRef.setDelFlag(1);
        int count = 0;
        for (String classcardId : classcardIds) {
            ClassCardCustomRefExample example = new ClassCardCustomRefExample();
            example.createCriteria().andPageIdEqualTo(pageId).andClassCardIdEqualTo(classcardId);
            count += customRefMapper.updateByExampleSelective(classCardCustomRef,example);
        }
        return count;
    }
}
