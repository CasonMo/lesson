package com.mo.controller;



import com.mo.domain.Admin;
import com.mo.domain.Lesson;
import com.mo.domain.Student;


import com.mo.domain.Teacher;
import com.mo.service.IAdminService;
import com.mo.service.ILessonService;
import com.mo.service.IStudentService;
import com.mo.service.ITeacherService;
import com.mo.tools.Jump;
import com.mo.tools.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: PeiHsien Mo
 * Date: 2019/11/7
 * Time: 19:56
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;
    @Autowired
    private ILessonService lessonService;
    @RequestMapping("/index")
    public String index(){
        return "student/index";
    }
    @RequestMapping("/findAll")
    public String findAll(){
        List<Student> all = studentService.findAll();
        for(Student student:all){
            System.out.println(student);
        }
        return "index/success";
    }
    @RequestMapping("/selected")
    public String findStuIdSelectedLessonById(Model model,HttpSession session){
        Student student = studentService.findStuIdSelectedLessonById((String)session.getAttribute("userId"));
//        Student student = studentService.findStuIdSelectedLessonById("417240335");
        model.addAttribute("student",student);
        return "student/selected";
    }

    @RequestMapping("/update/{id}")
    public String update(Model model, String verifyInput, HttpSession session, @PathVariable(name = "id") String id, Student student, String oldPassword, String rePassword, HttpServletResponse response, HttpServletRequest request) throws Exception {
        if(!verifyInput.toLowerCase().equals(((String)session.getAttribute("verifyCode")).toLowerCase())){
            response.sendRedirect(request.getContextPath()+"/login");
        }
        if(!rePassword.equals(student.getPassword())){
            return Jump.success(model,"两次输入密码不一致");
        }
        if(student.getPassword().equals(oldPassword)){
            return Jump.success(model,"不可以和原密码相同");
        }

        if(!studentService.findById(student.getStu_id()).getPassword().equals(DigestUtils.md5DigestAsHex(oldPassword.getBytes()))){
            return Jump.success(model,"原密码不正确");
        }
        student.setStu_id(id);
        student.setPassword(DigestUtils.md5DigestAsHex(student.getPassword().getBytes()));
        studentService.update(student);
        return Jump.success(model,"修改成功");

    }
    @RequestMapping("/edit")
    public String edit( Model model,HttpSession session) throws Exception {
        Student student = studentService.findById((String)session.getAttribute("userId"));
        model.addAttribute("student",student);
        return "student/edit";
    }
    @GetMapping("/lesson")
    public String lesson(Model model,HttpSession session,Integer page,String search){
        if(search ==null){
            Page p = new Page(model, page, lessonService.findByStuId((String) session.getAttribute("userId")).size(), 10, "/ssm/student/lesson");
            List<Lesson> lessons = lessonService.findByStuIdByPage((String)session.getAttribute("userId"),p.getPageSize(), (p.getCurrentPage() - 1) * p.getPageSize());
            model.addAttribute("lessons",lessons);
            return "student/lesson";
        }else {
            Page p = new Page(model, page, lessonService.findByStuIdAndSearch((String) session.getAttribute("userId"),search).size(), 10, "/ssm/student/lesson?search="+search);
            List<Lesson> lessons = lessonService.findByStuIdByPageAndSearch((String)session.getAttribute("userId"),p.getPageSize(), (p.getCurrentPage() - 1) * p.getPageSize(),search);
            model.addAttribute("lessons",lessons);
            return "student/lesson";
        }

    }

    @GetMapping("/selectLesson")
    public String selectLesson(String stuId,String lessonId,Model model){
        String result = lessonService.selectLesson(stuId, lessonId);
        return Jump.success(model,result,"/ssm/student/lesson");
    }
    @GetMapping("/unSubLesson")
    public String unSubLesson(String stuId,String lessonId,Model model){
        String result = lessonService.unSubLesson(stuId, lessonId);
        return Jump.success(model,result,"/ssm/student/selected");
    }

}
