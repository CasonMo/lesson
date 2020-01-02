package com.mo.controller;

import com.mo.domain.Lesson;
import com.mo.service.ILessonService;
//import com.mo.tools.ClassAndMethods;
import com.mo.tools.ClassAndMethods;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: PeiHsien Mo
 * Date: 2019/11/10
 * Time: 21:22
 */
@Controller
@RequestMapping("/lesson")
public class LessonController {
    @Autowired
    private ILessonService lessonService;

    @RequestMapping("/findAll")
    public void findAll(Model model) {
        List<Lesson> lessons = lessonService.findAll();
        model.addAttribute("lessons",lessons);
    }
    @RequestMapping("/findByStuId")
    public void findByStuId(Model model){
        List<Lesson> lessons = lessonService.findByStuId("417240332");
        model.addAttribute("lessons",lessons);
    }
    @RequestMapping("/findByTeachId")
    public String findByTeachId(){
        List<Lesson> lessons = lessonService.findByTeachId("th_001");
        for(Lesson lesson:lessons){
            System.out.println(lesson);
        }
        return "index/success";
    }
    @RequestMapping("/findLessonSelectedByLessonIDAndTeachId")
    public String findLessonSelectedByLessonIDAndTeachId(){
        Lesson lesson = lessonService.findLessonSelectedByLessonIDAndTeachId("th_001","0005");

            System.out.println(lesson);

        return "index/success";
    }
}
