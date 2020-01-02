package com.mo.domain;

import java.util.List;

public class Lesson {
    private String lesson_id;
    private String name;
    private Integer limit;
    private String teach_id;
    private String teach_place;
    private String class_id;
    private String teach_time;
    private Integer selected;

    private Teacher teacher;
    private Class_ class_;

    private List<Student> students;
    public Class_ getClass_() {
        return class_;
    }

    public void setClass_(Class_ class_) {
        this.class_ = class_;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(String lesson_id) {
        this.lesson_id = lesson_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getSelected() {
        return selected;
    }

    public void setSelected(Integer selected) {
        this.selected = selected;
    }

    public String getTeach_id() {
        return teach_id;
    }

    public void setTeach_id(String teach_id) {
        this.teach_id = teach_id;
    }

    public String getTeach_place() {
        return teach_place;
    }

    public void setTeach_place(String teach_place) {
        this.teach_place = teach_place;
    }



    public String getTeach_time() {
        return teach_time;
    }

    public void setTeach_time(String teach_time) {
        this.teach_time = teach_time;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "lesson_id='" + lesson_id + '\'' +
                ", name='" + name + '\'' +
                ", limit=" + limit +
                ", teach_id='" + teach_id + '\'' +
                ", teach_place='" + teach_place + '\'' +
                ", class_id='" + class_id + '\'' +
                ", teach_time='" + teach_time + '\'' +
                ", selected=" + selected +
                ", teacher=" + teacher +
                ", class_=" + class_ +
                ", students=" + students +
                '}';
    }
}
