package cc.ligu.mvc.service;

import cc.ligu.mvc.persistence.entity.Role;
import cc.ligu.mvc.persistence.entity.RoleMenu;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by conn on 2016/8/8.
 */
public interface RoleService {

    PageInfo<Role> findAllList(int pageNum, int pageSize);

    Role findRoleById(int id);

    int updateRole(Role role);

    int insertRole(Role role);

    /**
     * roleId 查询roleMenu
     * @param roleId
     * @return
     */
    List<RoleMenu> findRoleMenuList(int roleId);

    /**
     * 添加角色对于的menu
     * @param roleId
     * @param menuId
     * @return
     */
    int assignRoleMenu(int roleId, int menuId);

    /**
     * 删除角色对于的menu
     * @param roleId
     * @param menuId
     * @return
     */
    int deleteRoleMenu(int roleId, int menuId);

}
