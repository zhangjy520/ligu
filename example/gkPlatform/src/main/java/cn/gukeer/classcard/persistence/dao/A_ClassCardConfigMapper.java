package cn.gukeer.classcard.persistence.dao;

import cn.gukeer.classcard.modelView.ClassCardConfigScreenOffView;
import cn.gukeer.classcard.modelView.ClassCardConfigView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface A_ClassCardConfigMapper {

    List<ClassCardConfigView> findAllConfigViewBySchoolId(String schoolId);

    List<ClassCardConfigView> findAllConfigViewByUserId(String userId);

    List<ClassCardConfigView> findAllConfigByClassCardIds(@Param("classCardIds") List<String> classCardIds);

    List<ClassCardConfigView> findAllConfigView();

    ClassCardConfigView findOneConfigViewById(String id);

    List<ClassCardConfigScreenOffView> findListClassCardScreenOffByCCCId(String classCardConfigId);

}
