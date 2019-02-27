package cc.ligu.mvc.service.impl;

import cc.ligu.common.service.BasicService;
import cc.ligu.common.utils.DicUtil;
import cc.ligu.mvc.persistence.dao.PersonSalaryMapper;
import cc.ligu.mvc.persistence.entity.PersonSalary;
import cc.ligu.mvc.persistence.entity.PersonSalaryExample;
import cc.ligu.mvc.service.PersonSalaryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;


/**
 * Created by zjy on 2018/5/21.
 */
@Service
public class PersonSalaryServiceImpl extends BasicService implements PersonSalaryService {

    @Autowired
    PersonSalaryMapper personSalaryMapper;

    @Override
    public PageInfo<PersonSalary> listAllPersonSalary(int pageSize, int pageNum, PersonSalary personSalary) {
        PersonSalaryExample personExample = new PersonSalaryExample();
        PersonSalaryExample.Criteria criteria = personExample.createCriteria();
        if (null != personSalary && !StringUtils.isEmpty(personSalary.getPersonName())) {
            criteria.andPersonNameLike("%" + personSalary.getPersonName() + "%");
        }

        PageHelper.startPage(pageNum, pageSize);
        List<PersonSalary> personSalaryList = personSalaryMapper.selectByExample(personExample);

        for (PersonSalary view : personSalaryList) {
            if (!StringUtils.isEmpty(view.getZhengJuUrls())) {
                view.setZhengJuList(DicUtil.splitWithOutNull(view.getZhengJuUrls()));
            }
        }

        PageInfo<PersonSalary> page = new PageInfo<PersonSalary>(personSalaryList);

        return page;
    }

    @Override
    public List<PersonSalary> listAllPersonSalary(PersonSalary personSalary) {
        PersonSalaryExample example = new PersonSalaryExample();
        example.createCriteria();
        return personSalaryMapper.selectByExample(example);
    }

    @Override
    public int savePersonSalary(PersonSalary personSalary) {
        if (StringUtils.isEmpty(personSalary.getId())) {
            personSalaryMapper.insertSelective(personSalary);
        } else {
            personSalaryMapper.updateByPrimaryKeySelective(personSalary);
        }
        return 1;
    }

    @Override
    public PersonSalary selectPersonSalaryByPrimary(int personSalaryId) {
        return personSalaryMapper.selectByPrimaryKey(personSalaryId);
    }

    @Override
    public int deletePersonSalary(int personSalaryId) {
        return personSalaryMapper.deleteByPrimaryKey(personSalaryId);
    }


    @Override
    public List<PersonSalary> selectPersonSalaryByIdNum(String idNum) {
        PersonSalaryExample personExample = new PersonSalaryExample();
        personExample.createCriteria().andPersonNumEqualTo(idNum);

        List<PersonSalary> personList = personSalaryMapper.selectByExample(personExample);
        return personList;
    }


}
