package cc.ligu.mvc.service.impl;

import cc.ligu.common.service.BasicService;
import cc.ligu.mvc.persistence.dao.UserMapper;
import cc.ligu.mvc.persistence.dao.UserViewMapper;
import cc.ligu.mvc.persistence.entity.User;
import cc.ligu.mvc.persistence.entity.UserView;
import cc.ligu.mvc.persistence.entity.UserViewExample;
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
    UserViewMapper userViewMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public UserView selectUserViewByPrimary(int refId) {
        UserViewExample example = new UserViewExample();
        example.createCriteria().andRefIdEqualTo(refId);

        List<UserView> res = userViewMapper.selectByExample(example);
        if (res.size() > 0)
            return res.get(0);
        return null;
    }

    @Override
    public User selectUserViewByUserId(int userId) {

        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public UserView selectUserViewByUsernameAndPassword(String username, String password) {
        UserViewExample example = new UserViewExample();
        example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);

        List<UserView> res = userViewMapper.selectByExample(example);
        if (res.size() > 0)
            return res.get(0);
        return null;
    }

    @Override
    public UserView selectUserViewByIdenti(String idNum) {
        UserViewExample example = new UserViewExample();
        example.createCriteria().andIdentityNumEqualTo(idNum);

        List<UserView> res = userViewMapper.selectByExample(example);
        if (res.size()>0)
            return res.get(0);
        return null;
    }

    @Override
    public List<UserView> selectUserViewByUserView(UserView userView) {
        UserViewExample example = new UserViewExample();
        UserViewExample.Criteria criteria = example.createCriteria();

        if(!StringUtils.isEmpty(userView.getIdentityNum())){
            criteria.andIdentityNumEqualTo(userView.getIdentityNum());
        }
        if (!StringUtils.isEmpty(userView.getName())){
            criteria.andNameLike("%"+userView.getName()+"%");
        }

        List<UserView> res = userViewMapper.selectByExample(example);
        return res;
    }

    @Override
    public int saveUser(User user, UserView userView) {
        if (StringUtils.isEmpty(user.getId())) {
            user.setCreateDate(System.currentTimeMillis());//创建时间
            user.setCreateBy(userView.getId());//创建人
            userMapper.insertSelective(user);
        } else {
            user.setUpdateDate(System.currentTimeMillis());
            user.setUpdateBy(userView.getId());
            userMapper.updateByPrimaryKeySelective(user);
        }
        return 1;
    }
}
