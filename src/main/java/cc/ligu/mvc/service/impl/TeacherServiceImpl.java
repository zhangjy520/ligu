package cc.ligu.mvc.service.impl;

import cc.ligu.common.service.BasicService;
import cc.ligu.mvc.persistence.dao.TeacherMapper;
import cc.ligu.mvc.persistence.entity.Teacher;
import cc.ligu.mvc.persistence.entity.TeacherExample;
import cc.ligu.mvc.service.TeacherService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by conn on 2016/8/8.
 */
@Service
public class TeacherServiceImpl extends BasicService implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public PageInfo<Teacher> findAllList(int pageNum, int pageSize) {

        TeacherExample example = new TeacherExample();
        example.createCriteria().andDelFlagEqualTo(0);
        example.setOrderByClause("create_date desc");

        PageHelper.startPage(pageNum, pageSize);
        List<Teacher> list = teacherMapper.selectByExample(example);
        PageInfo<Teacher> pageInfo = new PageInfo<Teacher>(list);

        return pageInfo;
    }

    @Override
    public Teacher findTeacherById(int id) {

        Teacher teacher = teacherMapper.selectByPrimaryKey(id);
        return teacher;
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        TeacherExample example = new TeacherExample();
        example.createCriteria().andIdEqualTo(teacher.getId());
        int count = teacherMapper.updateByExampleSelective(teacher, example);
        return count;
    }

    @Override
    public int insertTeacher(Teacher teacher) {
        int count = teacherMapper.insertSelective(teacher);
        return count;
    }
}
