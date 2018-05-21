package cc.ligu.mvc.persistence.dao;

import cc.ligu.mvc.persistence.entity.Student;

/**
 * Created by conn on 16-10-11.
 */
public interface A_StudentExtensionMapper {

    Student selectStudentByMac(String mac);
    
}
