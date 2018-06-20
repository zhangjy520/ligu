package cn.gukeer.classcard.service;

import cn.gukeer.classcard.modelView.ClassCardConfigView;
import cn.gukeer.classcard.persistence.entity.ClassCardConfig;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 开关机配置
 */
public interface ClassCardConfigService {

    PageInfo<ClassCardConfigView> findAllConfigBySchoolId(String schoolId, int pageNum, int pageSize);

    PageInfo<ClassCardConfigView> findAllConfigByUserId(String userId, int pageNum, int pageSize);

    PageInfo<ClassCardConfigView> findAllConfigByClassCardIds(List<String>classCardIds, int pageNum, int pageSize);

    PageInfo<ClassCardConfigView> findAllConfig(int pageNum, int pageSize);

    List<ClassCardConfigView> transforConfig(List<ClassCardConfigView> classCardConfigList);

    ClassCardConfigView transforConfigOne(ClassCardConfigView classCardConfigList);

    Integer insertClassCardConfig(ClassCardConfig classCardConfig);

    ClassCardConfigView findOneClassCardConfigById(String classCardConfigId);

    Integer updateClassCardConfig(ClassCardConfig classCardConfig);

    Integer deleteClassCardConfig(String[] configIdArr);

    List<ClassCardConfigView> findConfigListView(List<String> configList);
}
