package com.mo.service;

import com.mo.domain.Teacher;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: PeiHsien Mo
 * Date: 2019/11/7
 * Time: 18:12
 */
public interface ITeacherService {
    public Teacher find(String id, String password);
    public Teacher findById(String id);
    public void update(Teacher teacher);
    public Teacher findByTeachId(String teach_id);
    public String addTeacher(Teacher teacher);
    public List<Teacher> AllTeacher();
    public List<Teacher> AllTeacherByPage(Integer pageSize,Integer preTotal);

    public List<Teacher> AllTeacherTempByPage(Integer pageSize,Integer preTotal);
    public List<Teacher> AllTeacherTemp();
    public String AddToTeacher(String id);
    public Integer deleteTeacherTemp(String id);
}
