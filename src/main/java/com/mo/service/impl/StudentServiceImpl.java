package com.mo.service.impl;

import com.mo.dao.IStudentDao;
import com.mo.domain.Student;
import com.mo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: PeiHsien Mo
 * Date: 2019/11/7
 * Time: 18:11
 */
@Service("studentService")
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentDao studentDao;
    @Override
    public List<Student> findAll(){
        List<Student> students = studentDao.findAll();
        return students;
    }

    @Override
    public Student find(String id, String password) {
        Student student = studentDao.find(id, password);
        return student;
    }

    @Override
    public void update(Student student) {
        studentDao.update(student);
    }

    @Override
    public Student findById(String id) {
        Student student = studentDao.findById(id);
        return student;
    }

    @Override
    public Student findStuIdSelectedLessonById(String stuId) {
        Student student = studentDao.findStuIdSelectedLessonById(stuId);
        return student;
    }

    @Override
    public String addStudent(Student student) {
        String result = studentDao.addStudent(student);
        return result;
    }

    @Override
    public List<Student> findStudentByPage(Integer pageSize, Integer preTotal) {
        List<Student> students = studentDao.findStudentByPage(pageSize, preTotal);
        return students;
    }

    @Override
    public List<Student> findAllStudentTemp() {
        List<Student> studentTemps = studentDao.findAllStudentTemp();
        return studentTemps;
    }

    @Override
    public List<Student> findAllStudentTempByPage(Integer pageSize, Integer preTotal) {
        List<Student> studentTemps = studentDao.findAllStudentTempByPage(pageSize,preTotal);
        return studentTemps;
    }

    @Override
    public String addToStudent(String id) {
        String result = studentDao.addToStudent(id);
        return result;
    }

    @Override
    public Integer deleteStudentTemp(String id) {
        Integer result = studentDao.deleteStudentTemp(id);
        return result;
    }
}
