package com.mo.service.impl;

import com.mo.dao.IClassDao;
import com.mo.domain.Class_;
import com.mo.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: PeiHsien Mo
 * Date: 2019/11/7
 * Time: 18:11
 */
@Service("classService")
public class ClassServiceImpl implements IClassService {
    @Autowired
    private IClassDao classDao;
    @Override
    public List<Class_> findAll() {
        List<Class_> classes = classDao.findAll();
        return classes;
    }

    @Override
    public Integer addClass(Class_ class_) {
        Integer result = classDao.addClass(class_);
        return result;
    }

    @Override
    public String deleteClass(String id) {
        String result = classDao.deleteClass(id);
        return result;
    }

    @Override
    public List<Class_> findAllDepartment() {
        List<Class_> allDepartment = classDao.findAllDepartment();
        return allDepartment;
    }

    @Override
    public List<Class_> findByDepartment(String department) {
        List<Class_> classes = classDao.findByDepartment(department);
        return classes;
    }

    @Override
    public List<Class_> findAllClassByPage(Integer pageSize, Integer preTotal) {
        List<Class_> classes = classDao.findAllClassByPage(pageSize, preTotal);
        return classes;
    }

    @Override
    public Class_ findById(String id) {
        Class_ class_ = classDao.findById(id);
        return class_;
    }

    @Override
    public Integer update(Class_ class_) {
        return classDao.update(class_);
    }
}
