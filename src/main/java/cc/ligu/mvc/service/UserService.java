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

    //获取所有保险过期的人员
    List<UserView> selectAllInsuPassUsers();

    //根据身份证查询该用户保险是否过期，如果过期，返回用户信息
    boolean isInsuPassByUserIdenty(String identi);

    //获取所有薪资过期的人员
    List<UserView> selectAllSalayPassUsers();

    //根据当前身份证判断是否薪资过期
    boolean isSalaryPassByUserIdenty(String identi,String type);
}
