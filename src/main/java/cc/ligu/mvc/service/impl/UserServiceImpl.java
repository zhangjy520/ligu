package cc.ligu.mvc.service.impl;

import cc.ligu.common.service.BasicService;
import cc.ligu.mvc.persistence.dao.UserMapper;
import cc.ligu.mvc.persistence.entity.User;
import cc.ligu.mvc.persistence.entity.UserExample;
import cc.ligu.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by zjy on 2018/5/21.
 */
@Service
public class UserServiceImpl extends BasicService implements UserService {

    @Autowired
    UserMapper userMapper;

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
}
