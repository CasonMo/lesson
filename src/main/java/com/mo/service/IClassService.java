package com.mo.service;

import com.mo.domain.Class_;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: PeiHsien Mo
 * Date: 2019/11/7
 * Time: 18:11
 */
public interface IClassService {
    public List<Class_> findAll();
    public Integer addClass(Class_ class_);
    public String deleteClass(String id);
    public List<Class_> findAllDepartment();
    public List<Class_> findByDepartment(String department);
    public List<Class_> findAllClassByPage(Integer pageSize, Integer preTotal);
    public Class_ findById(String id);
    public Integer update(Class_ class_);
}
