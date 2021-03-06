package cc.ligu.mvc.service.impl;

import cc.ligu.common.security.AESencryptor;
import cc.ligu.common.service.BasicService;
import cc.ligu.common.utils.DicUtil;
import cc.ligu.mvc.persistence.dao.ApiMapper;
import cc.ligu.mvc.persistence.dao.PersonMapper;
import cc.ligu.mvc.persistence.dao.UserMapper;
import cc.ligu.mvc.persistence.entity.*;
import cc.ligu.mvc.service.PersonService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;


/**
 * Created by zjy on 2018/5/21.
 */
@Service
public class PersonServiceImpl extends BasicService implements PersonService {

    @Autowired
    PersonMapper personMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    ApiMapper apiMapper;

    @Override
    public PageInfo<Person> listAllPerson(int pageSize, int pageNum, Person person) {
        PersonExample personExample = new PersonExample();
        PersonExample.Criteria criteria = personExample.createCriteria();

        if (null!=person&&!StringUtils.isEmpty(person.getName())) {
            criteria.andNameLike("%" + person.getName() + "%");
        }
        if (null!=person&&person.getType() != 0) {
            criteria.andTypeEqualTo(person.getType());
        }

        PageHelper.startPage(pageNum, pageSize);
        List<Person> personList = personMapper.selectByExample(personExample);
        PageInfo<Person> page = new PageInfo<Person>(personList);
        return page;
    }

    @Override
    public List<Person> listAllPerson(Person person) {
        PersonExample example = new PersonExample();
        PersonExample.Criteria criteria = example.createCriteria().andDelFlagEqualTo(0);
        if (StringUtils.isEmpty(person.getBlackFlag()) || person.getBlackFlag() != 0) {
            criteria.andBlackFlagEqualTo(person.getBlackFlag());
        }

        return personMapper.selectByExample(example);
    }

    @Transactional
    @Override
    public int savePerson(Person person, UserView userView) {
        int flag = 0;
        List<String> li = new ArrayList<>();
        if (null != person.getType() && person.getType() != 5) {
            //管理员设置，默认已审核！审核未审核只针对施工人员
            person.setStatus(1);
        }

        if (!StringUtils.isEmpty(person.getName()) && !StringUtils.isEmpty(person.getIdentityNum())) {
            //如果用户的姓名+身份证不为空，到库里查该人员，如果有该人员，做修改，否则进行下面的操作
            PersonExample example = new PersonExample();
            example.createCriteria().andIdentityNumEqualTo(person.getIdentityNum());

            List<Person> personLis = personMapper.selectByExample(example);
            if (personLis.size() > 0) {
                person.setId(personLis.get(0).getId());
                flag = -2;
            }
        }

        if (StringUtils.isEmpty(person.getId())) {
            person.setCreateBy(userView.getId());//创建人
            person.setCreateDate(System.currentTimeMillis());//创建时间
            personMapper.insertSelective(person);

            //新增一个人，对应创建一个账号
            User user = new User();
            user.setRefId(person.getId());
            user.setUsername(person.getIdentityNum());
            user.setPassword(AESencryptor.encryptCBCPKCS5Padding("000000"));
            user.setName(person.getName());
            user.setCreateBy(userView.getId());
            user.setCreateDate(System.currentTimeMillis());

            userMapper.insertSelective(user);
        } else {
            person.setUpdateBy(userView.getId());
            person.setUpdateDate(System.currentTimeMillis());
            personMapper.updateByPrimaryKeySelective(person);
            li.add(person.getName());
        }
        for (int i = 0; i < li.size(); i++) {
            System.out.println(li.get(i));
        }
        return flag;
    }

    @Override
    public Person selectPersonByPrimary(int personId) {
        return personMapper.selectByPrimaryKey(personId);
    }

    @Transactional
    @Override
    public int deletePerson(Person person) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andRefIdEqualTo(person.getId());
        userMapper.deleteByExample(userExample);
        personMapper.deleteByPrimaryKey(person.getId());
        return 1;
    }

    @Override
    public List<String> getAllSelect(int type) {
        List<String> selectList = apiMapper.getAllSelect(type);
        List<String> res = new ArrayList<>();
        for (String select : selectList) {
            if (!StringUtils.isEmpty(select)) {
                res.add(select);
            }
        }
        return res;
    }

    @Override
    public int changeUserPwd(int sysUserId, String pwd) {
        User user = new User();
        user.setPassword(AESencryptor.encryptCBCPKCS5Padding(pwd));
        user.setId(sysUserId);
        user.setUpdateBy(sysUserId);
        user.setUpdateDate(System.currentTimeMillis());
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public Person selectPersonByIdNum(String idNum) {
        PersonExample personExample = new PersonExample();
        personExample.createCriteria().andIdentityNumEqualTo(idNum);

        List<Person> personList = personMapper.selectByExample(personExample);
        if (personList.size() > 0) {
            return personList.get(0);
        }
        return null;
    }

    @Override
    public HashMap getAllCompanyInfo() {
        Date monthStart = doGetMonthStart(Calendar.getInstance());

        HashMap report = new HashMap();
        List<HashMap> res = apiMapper.getAllCompanyInfo();
        report.put("companyNum", res.size());//中标队伍数量
        report.put("companyDetail", res);//中标队伍统计详情

        List info = new ArrayList();
        for (HashMap company : res) {
            String personIds = company.get("personIds").toString();
            List<String> personIdList = DicUtil.splitWithOutNull(personIds);//各中标队伍的人详情

            if (personIdList.size() > 0) {
                List passResult = apiMapper.getAllPass(personIdList, DicUtil.PASS_SCORE, String.valueOf(monthStart.getTime()));
                company.put("passNum", passResult.size());//该中标队伍的及格人数

                List<HashMap> roleResult = apiMapper.getAllRoleInfo(personIdList);
                company.put("roleDetail", roleResult);

                for (Map m : roleResult) {
                    m.put("roleName",DicUtil.getValueByKeyAndFlag(Integer.valueOf(m.get("type").toString()),"personType"));
                    m.remove("personIds");
                }
            }
            company.remove("personIds");

        }
        return report;
    }

    private static Date doGetMonthStart(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        return calendar.getTime();
    }
}
