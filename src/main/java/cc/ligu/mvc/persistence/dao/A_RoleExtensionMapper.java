package cc.ligu.mvc.persistence.dao;

import cc.ligu.mvc.modelView.RoleView;

import java.util.List;

/**
 * Created by conn on 2016/8/19.
 */
public interface A_RoleExtensionMapper {
    List<RoleView> selectRoleViewByUserId(Integer userId);
}
