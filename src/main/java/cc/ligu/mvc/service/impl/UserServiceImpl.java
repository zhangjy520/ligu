package cc.ligu.mvc.service.impl;

import cc.ligu.common.service.BasicService;
import cc.ligu.common.utils.DicUtil;
import cc.ligu.common.utils.GsonUtil;
import cc.ligu.mvc.modelView.BaoXianView;
import cc.ligu.mvc.persistence.dao.PersonSalaryMapper;
import cc.ligu.mvc.persistence.dao.UserMapper;
import cc.ligu.mvc.persistence.dao.UserViewMapper;
import cc.ligu.mvc.persistence.entity.*;
import cc.ligu.mvc.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    PersonSalaryMapper salaryMapper;

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
        if (res.size() > 0)
            return res.get(0);
        return null;
    }

    @Override
    public List<UserView> selectUserViewByUserView(UserView userView) {
        UserViewExample example = new UserViewExample();
        UserViewExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(userView.getIdentityNum())) {
            criteria.andIdentityNumEqualTo(userView.getIdentityNum());
        }
        if (!StringUtils.isEmpty(userView.getName())) {
            criteria.andNameLike("%" + userView.getName() + "%");
        }

        List<UserView> res = userViewMapper.selectByExample(example);

        for (UserView view : res) {
            //关联查询薪资信息。这里身份证查的结果为一条，这里再查数据库不算循环
            PersonSalaryExample salaryExample = new PersonSalaryExample();
            salaryExample.createCriteria().andPersonNumEqualTo(view.getIdentityNum());
            List<PersonSalary> salaryList = salaryMapper.selectByExample(salaryExample);
            for (PersonSalary salary : salaryList) {
                if (!StringUtils.isEmpty(salary.getZhengJuUrls())) {
                    salary.setZhengJuList(DicUtil.splitWithOutNull(salary.getZhengJuUrls()));
                }
            }
            view.setSalaryList(salaryList);
        }
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

    @Override
    public List<UserView> selectAllInsuPassUsers() {
        UserViewExample example = new UserViewExample();
        example.createCriteria().andInsurancePurchasesIsNotNull();
        List<UserView> userViewList = userViewMapper.selectByExample(example);

        List<UserView> passUsers = new ArrayList<>();
        for (UserView userView : userViewList) {
            BaoXianView baoxian = GsonUtil.fromJson(userView.getInsurancePurchases(), BaoXianView.class);
            if (DicUtil.formatDate(baoxian.getOrder_time()) < System.currentTimeMillis()) {
                //保险结束日期小于当前日期，说明保险过期了
                passUsers.add(userView);
            }
        }

        return passUsers;
    }

    @Override
    public boolean isInsuPassByUserIdenty(String identi) {
        UserViewExample example = new UserViewExample();
        example.createCriteria().andInsurancePurchasesIsNotNull().andIdentityNumEqualTo(identi);
        List<UserView> userViewList = userViewMapper.selectByExample(example);
        if (userViewList.size() == 0) {
            return true;
        }
        for (UserView userView : userViewList) {
            BaoXianView baoxian = GsonUtil.fromJson(userView.getInsurancePurchases(), BaoXianView.class);
            if (DicUtil.formatDate(baoxian.getOrder_time()) < System.currentTimeMillis()) {
                //保险结束日期小于当前日期，说明保险过期了
                return true;
            }
        }
        return false;
    }

    @Override
    public List<UserView> selectAllSalayPassUsers() {
        return null;
    }

    @Override
    public boolean isSalaryPassByUserIdenty(String identi,String type) {
        try {
            PersonSalaryExample example = new PersonSalaryExample();
            example.createCriteria().andPersonNumEqualTo(identi).andFeeTypeEqualTo(type);
            example.setOrderByClause("send_time DESC");

            PageHelper.startPage(0, 1);
            List<PersonSalary> res = salaryMapper.selectByExample(example);
            if (res.size() > 0) {
                Date date = DicUtil.dateFormatSalary.parse(res.get(0).getSendTime());
                if (date.getTime() < System.currentTimeMillis()) {
                    //薪资时间小于当前时间，说明发放日期已超过当前日期，薪资未录入
                    return true;
                }
            } else {
                //没查到薪资录入信息，也是无效
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return false;
    }

}
