package cc.ligu.mvc.modelView;

import cc.ligu.mvc.persistence.entity.Menu;
import cc.ligu.mvc.persistence.entity.User;
import cc.ligu.mvc.persistence.entity.UserRole;

import java.util.List;

/**
 * Created by conn on 2016/8/19.
 */
public class UserView extends User {

    private UserRole userRole;

    private List<Menu> menus;


    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

}
