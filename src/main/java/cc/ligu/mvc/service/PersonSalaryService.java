package cc.ligu.mvc.service;

import cc.ligu.mvc.persistence.entity.PersonSalary;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface PersonSalaryService {
    PageInfo<PersonSalary> listAllPersonSalary(int pageSize, int pageNum, PersonSalary personSalary);

    List<PersonSalary> listAllPersonSalary(PersonSalary personSalary);

    int savePersonSalary(PersonSalary personSalary);

    PersonSalary selectPersonSalaryByPrimary(int personSalaryId);

    int deletePersonSalary(int personSalaryId);

    //根据人员身份证号码查询人员薪资
    List<PersonSalary> selectPersonSalaryByIdNum(String idNum);

}
