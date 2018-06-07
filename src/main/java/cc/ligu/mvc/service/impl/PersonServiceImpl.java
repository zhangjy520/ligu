package cc.ligu.mvc.service.impl;

import cc.ligu.common.security.AESencryptor;
import cc.ligu.common.service.BasicService;
import cc.ligu.mvc.persistence.dao.PersonMapper;
import cc.ligu.mvc.persistence.dao.UserMapper;
import cc.ligu.mvc.persistence.entity.Person;
import cc.ligu.mvc.persistence.entity.PersonExample;
import cc.ligu.mvc.persistence.entity.User;
import cc.ligu.mvc.persistence.entity.UserView;
import cc.ligu.mvc.service.PersonService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;


/**
 * Created by zjy on 2018/5/21.
 */
@Service
public class PersonServiceImpl extends BasicService implements PersonService {

    @Autowired
    PersonMapper personMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public PageInfo<Person> listAllPerson(int pageSize, int pageNum, Person person) {
        PersonExample personExample = new PersonExample();
        PersonExample.Criteria criteria = personExample.createCriteria();

        if (!StringUtils.isEmpty(person.getName())) {
            criteria.andNameLike("%" + person.getName() + "%");
        }
        if (person.getType() != 0) {
            criteria.andTypeEqualTo(person.getType());
        }

        PageHelper.startPage(pageNum, pageSize);
        List<Person> personList = personMapper.selectByExample(personExample);
        PageInfo<Person> page = new PageInfo<Person>(personList);
        return page;
    }

    @Override
    public List<Person> listAllPerson() {
        PersonExample example = new PersonExample();
        example.createCriteria().andDelFlagEqualTo(0);
        return personMapper.selectByExample(example);
    }

    @Transactional
    @Override
    public int savePerson(Person person, UserView userView) {
        if (person.getType() != 5) {
            //管理员设置，默认已审核！审核未审核只针对施工人员
            person.setStatus(1);
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
        }
        return 1;
    }

    @Override
    public Person selectPersonByPrimary(int personId) {
        return personMapper.selectByPrimaryKey(personId);
    }

    @Override
    public int deletePerson(Person person) {
        return personMapper.deleteByPrimaryKey(person.getId());
    }
}
