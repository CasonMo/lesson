package com.mo.controller;

import com.mo.domain.Class_;
import com.mo.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: PeiHsien Mo
 * Date: 2019/11/20
 * Time: 16:21
 */
@Controller
@RequestMapping("/class")
public class ClassController {
    @Autowired
    private IClassService classService;
    @RequestMapping("/findByDepartment")
    public void findByDepartment(String department,HttpServletResponse response) throws Exception {
        List<Class_> classes = classService.findByDepartment(department);
        String message = " <option selected disabled value=\"\">下拉选择班级</option>";
        for(Class_ class_:classes){
            message += "  <option   value=\""+class_.getClass_id()+"\">"+class_.getName()+"</option>";
        }

        response.setContentType("text/xml;charset=UTF-8");
        response.getWriter().write(message);

    }

}
