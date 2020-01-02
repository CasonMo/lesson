package com.mo.dao;

import com.mo.domain.Class_;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: PeiHsien Mo
 * Date: 2019/11/7
 * Time: 18:09
 */
@Repository
public interface IClassDao {
    @Select("select * from class")
    public List<Class_> findAll();
    @Select("select department from class group by department")
    public List<Class_> findAllDepartment();
    @Select("select name,class_id from class where department =#{department}")
    public List<Class_> findByDepartment(String department);
    @Insert("insert into class(class_id,name,department) values(#{class_id},#{name},#{department})")
    public Integer addClass(Class_ class_);
    @Select("DECLARE @result varchar(20) EXEC Proc_DeleteClass @id = #{id},@result = @result OUTPUT SELECT @result as N'@result'")
    public String deleteClass(String id);
    @Select("select top ${pageSize} * from class where class_id not in (select top ${preTotal} class_id  from class)")
    public List<Class_> findAllClassByPage(@Param(value = "pageSize") Integer pageSize, @Param(value = "preTotal")Integer preTotal);
    @Select("select * from class where class_id = #{id}")
    public Class_ findById(String id);
    @Update("update class set name=#{name},department=#{department} where class_id = #{class_id}")
    public Integer update(Class_ class_);
}
