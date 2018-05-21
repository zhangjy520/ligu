package cc.ligu.mvc.persistence.dao;


import cc.ligu.mvc.modelView.MenuView;

import java.util.List;

/**
 * Created by conn on 2016/8/21.
 */
public interface A_MenuExtensionMapper {
    List<MenuView> selectMenusByRoleId(Integer roleId);
}
