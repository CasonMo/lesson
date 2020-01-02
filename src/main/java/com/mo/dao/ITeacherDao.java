package com.mo.dao;

import com.mo.domain.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: PeiHsien Mo
 * Date: 2019/11/7
 * Time: 18:09
 */
@Repository
public interface ITeacherDao {
    public Teacher find(@Param(value = "id") String id, @Param(value = "password")String password);
    public Teacher findById(String id);
    public void update(Teacher teacher);
    public Teacher findByTeachId(String teach_id);
    public List<Teacher> AllTeacher();
    @Select("DECLARE @result varchar(30) EXEC Proc_AddTeacher @id = #{teach_id},@name = #{name},@password = #{password},@sex = #{sex},@result = @result OUTPUT SELECT @result as N'@result'")
    public String addTeacher(Teacher teacher);
    @Select("select top ${pageSize} * from teacher where teach_id not in (select top ${preTotal} teach_id  from teacher)")
    public List<Teacher> AllTeacherByPage(@Param(value = "pageSize") Integer pageSize,@Param(value = "preTotal")Integer preTotal);
    @Select("select top ${pageSize} * from teacherTemp where teach_id not in (select top ${preTotal} teach_id  from teacherTemp)")
    public List<Teacher> AllTeacherTempByPage(@Param(value = "pageSize") Integer pageSize,@Param(value = "preTotal")Integer preTotal);
    @Select("select  * from teacherTemp")
    public List<Teacher> AllTeacherTemp();
    @Select("DECLARE @id varchar(10) DECLARE @result varchar(20) EXECUTE  Proc_AddToTeacher #{id},@result OUTPUT")
    public String AddToTeacher(String id);
    @Delete("delete from TeacherTemp where teach_id = #{id}")
    public Integer deleteTeacherTemp(String id);
}
