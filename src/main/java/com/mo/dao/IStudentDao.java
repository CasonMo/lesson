package com.mo.dao;

import com.mo.domain.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: PeiHsien Mo
 * Date: 2019/11/7
 * Time: 18:10
 */
@Repository
public interface IStudentDao {
    public List<Student> findAll();
    public Student find(@Param(value = "id") String id, @Param(value = "password")String password);
    public void update(Student student);
    public Student findById(String id);
    public Student findStuIdSelectedLessonById(String stuId);
    public String addStudent(Student student);
    public List<Student> findStudentByPage(@Param(value = "pageSize") Integer pageSize,@Param(value = "preTotal")Integer preTotal);
    public List<Student> findAllStudentTemp();
    public List<Student> findAllStudentTempByPage(@Param(value = "pageSize") Integer pageSize,@Param(value = "preTotal")Integer preTotal);
    @Select("DECLARE @id varchar(10) DECLARE @result varchar(30) EXECUTE  Proc_AddToStudent #{id},@result OUTPUT")
    public String addToStudent(String id);
    @Delete("delete from studentTemp where stu_id =#{id}")
    public Integer deleteStudentTemp(String id);
}
