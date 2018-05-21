package cc.ligu.mvc.service.impl;

import cc.ligu.common.service.BasicService;
import cc.ligu.mvc.persistence.dao.A_StudentExtensionMapper;
import cc.ligu.mvc.persistence.dao.StudentMapper;
import cc.ligu.mvc.persistence.entity.Student;
import cc.ligu.mvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends BasicService implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    A_StudentExtensionMapper extensionMapper;

    @Override
    public Student selectStudentByMac(String mac) {
        return extensionMapper.selectStudentByMac(mac);
    }

    @Override
    public Student selectByPrimaryKey(Integer studentId) {
        return studentMapper.selectByPrimaryKey(studentId);
    }
}
