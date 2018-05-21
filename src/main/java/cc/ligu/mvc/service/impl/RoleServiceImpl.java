package cc.ligu.mvc.service.impl;

import cc.ligu.common.service.BasicService;
import cc.ligu.mvc.persistence.dao.RoleMapper;
import cc.ligu.mvc.persistence.dao.RoleMenuMapper;
import cc.ligu.mvc.persistence.entity.Role;
import cc.ligu.mvc.persistence.entity.RoleExample;
import cc.ligu.mvc.persistence.entity.RoleMenu;
import cc.ligu.mvc.persistence.entity.RoleMenuExample;
import cc.ligu.mvc.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by conn on 2016/8/8.
 */
@Service
public class RoleServiceImpl extends BasicService implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    RoleMenuMapper roleMenuMapper;

    @Override
    public PageInfo<Role> findAllList(int pageNum, int pageSize) {

        RoleExample example = new RoleExample();
        example.createCriteria().andDelFlagEqualTo(0);
        example.setOrderByClause("create_date desc");

        PageHelper.startPage(pageNum, pageSize);
        List<Role> list = roleMapper.selectByExample(example);
        PageInfo<Role> pageInfo = new PageInfo<Role>(list);

        return pageInfo;
    }

    @Override
    public Role findRoleById(int id) {

        Role role = roleMapper.selectByPrimaryKey(id);
        return role;
    }

    @Override
    public int updateRole(Role role) {
        RoleExample example = new RoleExample();
        example.createCriteria().andIdEqualTo(role.getId());
        int count = roleMapper.updateByExampleSelective(role, example);
        return count;
    }

    @Override
    public int insertRole(Role role) {
        int count = roleMapper.insertSelective(role);
        return count;
    }

    @Override
    public List<RoleMenu> findRoleMenuList(int roleId) {

        RoleMenuExample example = new RoleMenuExample();
        example.createCriteria().andRoleIdEqualTo(roleId);

        List<RoleMenu> roleMenuList = roleMenuMapper.selectByExample(example);

        return roleMenuList;
    }


    public RoleMenu findRoleMenu(int roleId, int menuId) {

        RoleMenuExample example = new RoleMenuExample();
        example.createCriteria().andRoleIdEqualTo(roleId).andMenuIdEqualTo(menuId);
        List<RoleMenu> roleMenus = roleMenuMapper.selectByExample(example);

        RoleMenu roleMenu = null;
        if (null != roleMenus && roleMenus.size() > 0) {
            roleMenu = roleMenus.get(0);
        }
        return roleMenu;
    }

    /**
     * 添加角色对于的menu
     * @param roleId
     * @param menuId
     * @return
     */
    @Override
    public int assignRoleMenu(int roleId, int menuId) {

        RoleMenu roleMenu = findRoleMenu(roleId, menuId);
        if (null != roleMenu) {
            return 0;
        }
        roleMenu = new RoleMenu();
        roleMenu.setRoleId(roleId);
        roleMenu.setMenuId(menuId);
        int count = roleMenuMapper.insert(roleMenu);
        return count;
    }

    /**
     * 删除角色对于的menu
     * @param roleId
     * @param menuId
     * @return
     */
    @Override
    public int deleteRoleMenu(int roleId, int menuId) {
        RoleMenuExample example = new RoleMenuExample();
        example.createCriteria().andRoleIdEqualTo(roleId).andMenuIdEqualTo(menuId);
        int count = roleMenuMapper.deleteByExample(example);
        return count;
    }

}
