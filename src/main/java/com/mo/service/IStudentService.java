package com.mo.service;

import com.mo.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: PeiHsien Mo
 * Date: 2019/11/7
 * Time: 18:11
 */
public interface IStudentService {
    public List<Student> findAll();
    public Student find(String id,String password);

    public void update(Student student);
    public Student findById(String id);
    public Student findStuIdSelectedLessonById(String stuId);
    public String addStudent(Student student);
    public List<Student> findStudentByPage(Integer pageSize,Integer preTotal);
    public List<Student> findAllStudentTemp();
    public List<Student> findAllStudentTempByPage(Integer pageSize,Integer preTotal);
    public String addToStudent(String id);
    public Integer deleteStudentTemp(String id);

}
