package cn.gukeer.classcard.service;

import cn.gukeer.classcard.persistence.entity.ClassCardConfigRef;

import java.util.List;

/**
 * 开关机配置与发布设备映射关系
 */
public interface ClassCardConfigRefService {

    Integer insertClassCardConfigRef(String refId, String schoolId , List<String> classCardList);

    Integer deleteClassCardConfigRef(String[] configIdArr, String schoolId);

    Integer deleteClassCardConfigRefOne(String classcardId,String configId);

    Integer updateClassCardConfigRef(String id, String schoolId , List<String> classCardList);

    String findClassCardConfigCheckedIds(String classCardConfigId, String schoolId);

    List<String> findConfigClasscardByConfigId(String configId);

    List<ClassCardConfigRef> findRefByConfigId(String configId);

    List<String> findConfigListByClasscardId(String classcardId);
}
