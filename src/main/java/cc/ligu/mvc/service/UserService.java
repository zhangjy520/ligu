package cc.ligu.mvc.service;

import cc.ligu.mvc.modelView.MenuView;
import cc.ligu.mvc.modelView.RoleView;
import cc.ligu.mvc.persistence.entity.User;

import java.util.List;

public interface UserService {

	User saveUser(User user);

	User getByAccountAndPwd(String account, String pwd);

	User getUserById(Integer userId);

	List<RoleView> selectRoleViewByUserId(Integer userId);

	List<MenuView> selectMenusByRoleId(Integer roleId);
}
