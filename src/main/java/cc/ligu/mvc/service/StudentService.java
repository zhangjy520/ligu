package cc.ligu.mvc.service;

import cc.ligu.mvc.persistence.entity.Student;

public interface StudentService {
    Student selectStudentByMac(String mac);

    Student selectByPrimaryKey(Integer studentId);
}
