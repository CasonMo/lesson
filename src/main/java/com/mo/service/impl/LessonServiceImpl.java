package com.mo.service.impl;


import com.mo.dao.ILessonDao;
import com.mo.domain.Lesson;
import com.mo.service.ILessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: PeiHsien Mo
 * Date: 2019/11/7
 * Time: 18:12
 */
@Service("lessonService")
public class LessonServiceImpl implements ILessonService {
    @Autowired
    private ILessonDao lessonDao;

    @Override
    public List<Lesson> findAll() {
        List<Lesson> lessons = lessonDao.findAll();
        return lessons;
    }

    @Override
    public List<Lesson> findByStuId(String stuId) {
        List<Lesson> lessons = lessonDao.findByStuId(stuId);
        return lessons;
    }

    @Override
    public List<Lesson> findByTeachId(String teachId) {
        List<Lesson> lessons = lessonDao.findByTeachId(teachId);
        return lessons;
    }

    @Override
    public Lesson findLessonSelectedByLessonIDAndTeachId(String teachId, String lessonId) {
        Lesson lesson = lessonDao.findLessonSelectedByLessonIDAndTeachId(teachId,lessonId);
        return lesson;
    }

    @Override
    public String selectLesson(String stu_id, String lesson_id) {
        String result = lessonDao.selectLesson(stu_id, lesson_id);
        return result;
    }

    @Override
    public String unSubLesson(String stu_id, String lesson_id) {
        String result = lessonDao.unSubLesson(stu_id, lesson_id);
        return result;

    }

    @Override
    public List<Lesson> findByStuIdByPage(String stu_id, Integer pageSize, Integer preTotal) {
        List<Lesson> lessons = lessonDao.findByStuIdByPage(stu_id, pageSize, preTotal);
        return lessons;
    }

    @Override
    public String deleteLesson(String lesson_id) {
        String result = lessonDao.deleteLesson(lesson_id);
        return result;
    }

    @Override
    public Lesson findLessonInfoByLessonIDAndTeachId(String teachId, String lessonId) {
        Lesson lesson = lessonDao.findLessonInfoByLessonIDAndTeachId(teachId, lessonId);
        return lesson;
    }

    @Override
    public Integer updateLesson(Lesson lesson) {
        Integer result = lessonDao.updateLesson(lesson);
        return result;
    }

    @Override
    public String saveLesson(Lesson lesson) {
        String result = lessonDao.saveLesson(lesson);
        return result;
    }

    @Override
    public List<Lesson> findByStuIdByPageAndSearch(String stu_id, Integer pageSize, Integer preTotal, String search) {
        List<Lesson> lessons = lessonDao.findByStuIdByPageAndSearch(stu_id, pageSize, preTotal,search);
        return lessons;
    }

    @Override
    public List<Lesson> findByStuIdAndSearch(String stuId, String search) {
        List<Lesson> lessons = lessonDao.findByStuIdAndSearch(stuId, search);
        return lessons;
    }
}
