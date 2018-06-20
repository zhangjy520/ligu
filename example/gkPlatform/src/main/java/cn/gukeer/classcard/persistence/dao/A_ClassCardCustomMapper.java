package cn.gukeer.classcard.persistence.dao;

import cn.gukeer.classcard.modelView.ClassCardConfigView;
import cn.gukeer.classcard.modelView.ClassCardCustomPageView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface A_ClassCardCustomMapper {
    List<ClassCardCustomPageView> findAllCustonPageBySchoolId(String schoolId);

    ClassCardCustomPageView findViewOneById(String pageId);

    List<ClassCardCustomPageView>findAllPageByUser(@Param("userId") String userId, @Param("schoolId") String schoolId);

    List<ClassCardCustomPageView> findAllConfigByClassCardIds(@Param("classCardIds") List<String> classCardIds,@Param("userId")String userId);
}
