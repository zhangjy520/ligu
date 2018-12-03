package cc.ligu.mvc.service;

import cc.ligu.mvc.persistence.entity.Person;
import cc.ligu.mvc.persistence.entity.UserView;
import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;

public interface PersonService {
    PageInfo<Person> listAllPerson(int pageSize, int pageNum, Person person);

    List<Person> listAllPerson(Person person);

    int savePerson(Person person, UserView userView);

    Person selectPersonByPrimary(int personId);

    int deletePerson(Person person);

    List<String> getAllSelect(int type);

    int changeUserPwd(int sysUserId,String pwd);

    //根据人员身份证号码查询人员
    Person selectPersonByIdNum(String idNum);

    //统计各中标公司的人员情况
    HashMap getAllCompanyInfo();
}
