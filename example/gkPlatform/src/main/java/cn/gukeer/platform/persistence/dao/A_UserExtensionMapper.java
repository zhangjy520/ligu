package cn.gukeer.platform.persistence.dao;

import cn.gukeer.platform.persistence.entity.Teacher;
import cn.gukeer.platform.persistence.entity.User;
import cn.gukeer.platform.persistence.entity.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by conn on 2016/8/19.
 */
public interface A_UserExtensionMapper {

    String insertUserBatch(List<User> userList);

    Integer insertUserRoleBatch(List<UserRole> userRole);

    List<Teacher> findTeacherByRoleIdAndSchoolId(@Param("roleId") String roleId, @Param("schoolId") String schoolId);
}
