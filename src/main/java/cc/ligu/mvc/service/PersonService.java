package cc.ligu.mvc.service;

import cc.ligu.mvc.persistence.entity.Person;
import cc.ligu.mvc.persistence.entity.UserView;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface PersonService {
    PageInfo<Person> listAllPerson(int pageSize, int pageNum, Person person);

    List<Person> listAllPerson();

    int savePerson(Person person, UserView userView);

    Person selectPersonByPrimary(int personId);

    int deletePerson(Person person);
}
