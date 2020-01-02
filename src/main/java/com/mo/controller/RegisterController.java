package com.mo.controller;

import com.mo.domain.Student;
import com.mo.domain.Teacher;
import com.mo.service.IClassService;
import com.mo.service.IStudentService;
import com.mo.service.ITeacherService;
import com.mo.tools.Jump;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: PeiHsien Mo
 * Date: 2019/11/20
 * Time: 18:04
 */
@Controller
@SessionAttributes(value = {"msg"})
public class RegisterController {
    @Autowired
    private IClassService classService;
    @Autowired
    private IStudentService studentService;
    @Autowired
    private ITeacherService teacherService;
    @RequestMapping("/register")
    public String register(Model model){

        model.addAttribute("pageTitle","注册");
        model.addAttribute("departmentList",classService.findAllDepartment());
        return "register";
    }

    @RequestMapping("/studentCheck")
    public String studentCheck(Model model,String verifyInput, HttpSession session,Student student,String password2,HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(!verifyInput.toLowerCase().equals(((String)session.getAttribute("verifyCode")).toLowerCase())){
            return Jump.success(model,"验证码不正确");
        }
            if(student.getStu_id().length() <6){

                return Jump.success(model,"账户长度必须长于6位");
            }else if(student.getPassword().length() <6){

                return Jump.success(model,"密码长度必须长于6位");
            } else if(!password2.equals(student.getPassword()) ){

                return Jump.success(model,"两次输入密码不一致");
            }else if(student.getClass_id() == null || student.getClass_id() ==" "){
                return Jump.success(model,"没有选择班级");
        }else{
                student.setPassword(DigestUtils.md5DigestAsHex(student.getPassword().getBytes()));
                String result =  studentService.addStudent(student);
                return Jump.success(model,result);
            }


        }
    @RequestMapping("/teacherCheck")
    public String teacherCheck(Model model, Teacher teacher, String password2, HttpServletRequest request, HttpServletResponse response) throws Exception {

        if(teacher.getTeach_id().length() <6){

            return Jump.success(model,"账户长度必须长于6位");
        }else if(teacher.getPassword().length() <6){

            return Jump.success(model,"密码长度必须长于6位");
        } else if(!password2.equals(teacher.getPassword()) ){

            return Jump.success(model,"两次输入密码不一致");
        }else{
            teacher.setPassword(DigestUtils.md5DigestAsHex(teacher.getPassword().getBytes()));
            String result =  teacherService.addTeacher(teacher);
            return Jump.success(model,result);
        }


    }



}
