package com.mo.controller;


import com.mo.domain.*;
import com.mo.service.*;
import com.mo.tools.Jump;
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
 * Date: 2019/11/11
 * Time: 0:06
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private IClassService classService;
    @Autowired
    private ITeacherService teacherService;
    @Autowired
    private ILessonService lessonService;
    @RequestMapping("/index")
    public String index(){
        return "teacher/index";
    }
    @RequestMapping("/update/{id}")
    public String update(Model model, String verifyInput, HttpSession session, @PathVariable(name = "id") String id, Teacher teacher, String oldPassword, String rePassword, HttpServletResponse response, HttpServletRequest request) throws Exception {
        if(!verifyInput.toLowerCase().equals(((String)session.getAttribute("verifyCode")).toLowerCase())){
            return Jump.success(model,"验证码不正确");
        }
        if(!rePassword.equals(teacher.getPassword())){
            return Jump.success(model,"两次输入密码不一致");
        }

        if(teacher.getPassword().equals(oldPassword)){
            return Jump.success(model,"不可以和原密码相同");
        }

        if(!teacherService.findById(teacher.getTeach_id()).getPassword().equals(DigestUtils.md5DigestAsHex(oldPassword.getBytes()))){
            return Jump.success(model,"原密码不正确");
        }
        teacher.setTeach_id(id);
        teacher.setPassword(DigestUtils.md5DigestAsHex(teacher.getPassword().getBytes()));
        teacherService.update(teacher);
        return Jump.success(model,"修改成功");

    }
    @RequestMapping("/edit")
    public String edit( Model model,HttpSession session) throws Exception {
        Teacher teacher = teacherService.findById((String)session.getAttribute("userId"));
        model.addAttribute("teacher",teacher);
        return "teacher/edit";
    }
    @RequestMapping("/lesson")
    public void lesson(Model model,HttpSession session) {
        Teacher teacher = teacherService.findByTeachId((String) session.getAttribute("userId"));
        model.addAttribute("teacher",teacher);
    }

    @RequestMapping("/deleteLesson/{id}")
    public String deleteLesson(Model model,@PathVariable(name = "id") String id){
        String result = lessonService.deleteLesson(id);
        return Jump.success(model,result,"/ssm/teacher/lesson");
    }

    @RequestMapping("/editLesson/{id}")
    public String editLesson(@PathVariable(name = "id") String id,Model model,HttpSession session){
        List<Class_> departments = classService.findAllDepartment();
        List<Class_> classes = classService.findAll();
        Lesson lesson = lessonService.findLessonInfoByLessonIDAndTeachId((String)session.getAttribute("userId"),id);

            model.addAttribute("departments", departments);
            model.addAttribute("classes",classes);
            model.addAttribute("lesson",lesson);
            return "teacher/editLesson";


    }
    @RequestMapping("/updateLesson/{id}")
    public String updateLesson(Model model, String verifyInput, HttpSession session, @PathVariable(name = "id") String id, Lesson lesson) throws Exception {
        if(!verifyInput.toLowerCase().equals(((String)session.getAttribute("verifyCode")).toLowerCase())){
            return Jump.success(model,"验证码不正确");
        }
        lesson.setLesson_id(id);
        Integer result = lessonService.updateLesson(lesson);
        if(result>0){
            return Jump.success(model,"修改成功");
        }else {

        return Jump.success(model,"修改失败");

        }

    }

    @RequestMapping("/addLesson")
    public void addLesson(Model model,HttpSession session){
        List<Class_> departments = classService.findAllDepartment();
        List<Class_> classes = classService.findAll();

        model.addAttribute("departments", departments);
        model.addAttribute("classes",classes);

    }
    @RequestMapping("/saveLesson")
    public String saveLesson(Model model, String verifyInput, HttpSession session,  Lesson lesson) throws Exception {
        if(!verifyInput.toLowerCase().equals(((String)session.getAttribute("verifyCode")).toLowerCase())){
            return Jump.success(model,"验证码不正确");
        }
        String result = lessonService.saveLesson(lesson);
        return Jump.success(model,result);


    }

    @GetMapping("/findLessonSelectedByLessonIDAndTeachId")
    public String findLessonSelectedByLessonIDAndTeachId(Model model,HttpSession session,String lesson_id){
        Teacher teacher = teacherService.findByTeachId((String) session.getAttribute("userId"));
        if(lesson_id!=null){
            Lesson lesson = lessonService.findLessonSelectedByLessonIDAndTeachId((String) session.getAttribute("userId"),lesson_id);
            model.addAttribute("students",lesson.getStudents());
        }
        model.addAttribute("lessons",teacher.getLessons());
        return "teacher/findLessonSelectedByLessonIDAndTeachId";
    }
}
