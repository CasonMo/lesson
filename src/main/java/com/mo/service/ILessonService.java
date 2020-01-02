package com.mo.service;

import com.mo.domain.Lesson;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: PeiHsien Mo
 * Date: 2019/11/7
 * Time: 18:12
 */
public interface ILessonService {
    public List<Lesson> findAll();
    public List<Lesson> findByStuId(String stuId);
    public List<Lesson> findByTeachId(String teachId);
    public Lesson findLessonSelectedByLessonIDAndTeachId(String teachId,String lessonId);
    public Lesson findLessonInfoByLessonIDAndTeachId(String teachId,String lessonId);
    public String selectLesson(String stu_id,String lesson_id);
    public String unSubLesson(String stu_id,String lesson_id);
    public List<Lesson> findByStuIdByPage(String stu_id,Integer pageSize,Integer preTotal);
    public String deleteLesson(String lesson_id);
    public Integer updateLesson(Lesson lesson);
    public String saveLesson(Lesson lesson);
    public List<Lesson> findByStuIdByPageAndSearch(String stu_id,Integer pageSize,Integer preTotal,String search);
    public List<Lesson> findByStuIdAndSearch(String stuId,String search);


}
