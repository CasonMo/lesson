package com.mo.dao;

import com.mo.domain.Lesson;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: PeiHsien Mo
 * Date: 2019/11/7
 * Time: 18:10
 */
public interface ILessonDao {
    public List<Lesson> findAll();
    public List<Lesson> findByStuId(String stuId);
    public List<Lesson> findByStuIdAndSearch(@Param(value = "stu_id") String stuId,@Param(value = "search")String search);
    public List<Lesson> findByTeachId(String teachId);
    public Lesson findLessonSelectedByLessonIDAndTeachId(@Param(value = "teachId") String teachId,@Param(value = "lessonId") String lessonId);
    public Lesson findLessonInfoByLessonIDAndTeachId(@Param(value = "teachId") String teachId,@Param(value = "lessonId") String lessonId);
    @Select("DECLARE @result varchar(100) EXEC Proc_SelectCourse @stu_id = #{stu_id},@lesson_id = #{lesson_id},@result = @result OUTPUT SELECT @result as N'@result' ")
    public String selectLesson(@Param(value = "stu_id") String stu_id,@Param(value = "lesson_id") String lesson_id);
    @Select("DECLARE @result varchar(20) EXEC Proc_DeleteCourse @stu_id = #{stu_id},@lesson_id = #{lesson_id},@result = @result OUTPUT SELECT @result as N'@result'" )
    public String unSubLesson(@Param(value = "stu_id") String stu_id,@Param(value = "lesson_id") String lesson_id);
    public List<Lesson> findByStuIdByPage(@Param(value = "stu_id") String stu_id,@Param(value = "pageSize") Integer pageSize,@Param(value = "preTotal") Integer preTotal);
    public List<Lesson> findByStuIdByPageAndSearch(@Param(value = "stu_id") String stu_id,@Param(value = "pageSize") Integer pageSize,@Param(value = "preTotal") Integer preTotal,@Param(value = "search") String search);
    @Select("DECLARE @result varchar(20) EXEC Proc_DeleteLesson @id =#{lesson_id},@result = @result OUTPUT SELECT @result as N'@result'")
    public String deleteLesson(String lesson_id);
    @Update("update lesson set name=#{name},teach_time = #{teach_time},teach_id=#{teach_id},teach_place = #{teach_place},class_id=#{class_id},limit=#{limit} where lesson_id = #{lesson_id}")
    public Integer updateLesson(Lesson lesson);
    public String saveLesson(Lesson lesson);
}
