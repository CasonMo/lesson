package com.mo.service.impl;

import com.mo.dao.ITeacherDao;
import com.mo.domain.Teacher;
import com.mo.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: PeiHsien Mo
 * Date: 2019/11/7
 * Time: 18:12
 */
@Service("teacherService")
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
    private ITeacherDao teacherDao;
    @Override
    public Teacher find(String id, String password) {
        Teacher teacher = teacherDao.find(id, password);
        return teacher;
    }

    @Override
    public Teacher findById(String id) {
        Teacher teacher = teacherDao.findById(id);
        return teacher;
    }

    @Override
    public void update(Teacher teacher) {
        teacherDao.update(teacher);
    }

    @Override
    public Teacher findByTeachId(String teach_id) {
        Teacher teacher = teacherDao.findByTeachId(teach_id);
        return teacher;
    }

    @Override
    public String addTeacher(Teacher teacher) {
        String result = teacherDao.addTeacher(teacher);
        return result;
    }

    @Override
    public List<Teacher> AllTeacher() {
        List<Teacher> teachers = teacherDao.AllTeacher();
        return teachers;
    }

    @Override
    public List<Teacher> AllTeacherByPage(Integer pageSize, Integer preTotal) {
        List<Teacher> teachers = teacherDao.AllTeacherByPage(pageSize, preTotal);
        return teachers;
    }

    @Override
    public List<Teacher> AllTeacherTempByPage(Integer pageSize, Integer preTotal) {
        List<Teacher> teachers = teacherDao.AllTeacherTempByPage(pageSize, preTotal);
        return teachers;
    }

    @Override
    public List<Teacher> AllTeacherTemp() {
        List<Teacher> teachers = teacherDao.AllTeacherTemp();
        return teachers;
    }

    @Override
    public String AddToTeacher(String id) {
        String result = teacherDao.AddToTeacher(id);
        return result;
    }

    @Override
    public Integer deleteTeacherTemp(String id) {
        Integer result = teacherDao.deleteTeacherTemp(id);
        return result;
    }
}
