package cc.ligu.mvc.service.impl;

import cc.ligu.common.service.BasicService;
import cc.ligu.mvc.modelView.MenuView;
import cc.ligu.mvc.modelView.RoleView;
import cc.ligu.mvc.persistence.dao.A_MenuExtensionMapper;
import cc.ligu.mvc.persistence.dao.A_RoleExtensionMapper;
import cc.ligu.mvc.persistence.dao.UserMapper;
import cc.ligu.mvc.persistence.entity.User;
import cc.ligu.mvc.persistence.entity.UserExample;
import cc.ligu.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by conn on 2016/7/27.
 */
@Service
public class UserServiceImpl extends BasicService implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    A_RoleExtensionMapper roleExtensionMapper;

    @Autowired
    A_MenuExtensionMapper menuExtensionMapper;

    @Override
    public User saveUser(User user) {
        User u = null;
        if (StringUtils.isEmpty(user.getId())) {
            user.setCreateDate(System.currentTimeMillis());
            int count = userMapper.insertSelective(user);
            System.out.print("ret num ======: " + count);
            u = user;
        } else {
            userMapper.updateByPrimaryKey(user);
        }
        logger.info("save user username: {} and createTime: {}", user.getUsername(), user.getCreateDate());
        return u;
    }

    @Override
    public User getByAccountAndPwd(String username, String pwd) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(pwd);
        List<User> users = (List<User>) userMapper.selectByExample(example);

        User user = null;
        if (null != users && users.size() > 0) {
            user = users.get(0);
            logger.info("login with username: {} and createTime: {}", user.getUsername(), user.getCreateDate());
        }
        return user;
    }

    @Override
    public User getUserById(Integer userId) {

        User user = userMapper.selectByPrimaryKey(userId);
        return user;
    }

    @Override
    public List<RoleView> selectRoleViewByUserId(Integer userId) {

        List<RoleView> roleViews = roleExtensionMapper.selectRoleViewByUserId(userId);

        return roleViews;
    }

    @Override
    public List<MenuView> selectMenusByRoleId(Integer roleId) {

        List<MenuView> menuViews = menuExtensionMapper.selectMenusByRoleId(roleId);

        return menuViews;
    }
}
