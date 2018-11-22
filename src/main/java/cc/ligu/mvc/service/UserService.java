package cc.ligu.mvc.service;


import cc.ligu.mvc.persistence.entity.User;
import cc.ligu.mvc.persistence.entity.UserView;

import java.util.List;

public interface UserService {

    UserView selectUserViewByPrimary(int refId);

    User selectUserViewByUserId(int userId);

    UserView selectUserViewByUsernameAndPassword(String username,String password);

    //通过身份证获取该用户
    UserView selectUserViewByIdenti(String idNum);

    List<UserView> selectUserViewByUserView(UserView userView);

    int saveUser(User user,UserView userView);
}
