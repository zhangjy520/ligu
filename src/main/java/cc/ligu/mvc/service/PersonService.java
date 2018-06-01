package cc.ligu.mvc.service;

import cc.ligu.mvc.persistence.entity.Person;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface PersonService {
    PageInfo<Person> listAllPerson(int pageSize, int pageNum, Person person);

    List<Person> listAllPerson();

    int savePerson(Person person);

    Person selectPersonByPrimary(int personId);

    int deletePerson(Person person);
}
