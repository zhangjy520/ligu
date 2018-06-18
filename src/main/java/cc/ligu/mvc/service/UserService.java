package cc.ligu.mvc.service;


import cc.ligu.mvc.persistence.entity.User;
import cc.ligu.mvc.persistence.entity.UserView;

public interface UserService {

    UserView selectUserViewByPrimary(int refId);

    User selectUserViewByUserId(int userId);

    UserView selectUserViewByUsernameAndPassword(String username,String password);

    int saveUser(User user,UserView userView);
}
