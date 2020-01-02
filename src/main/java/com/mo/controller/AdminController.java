package com.mo.controller;

import com.mo.domain.Admin;
import com.mo.domain.Class_;
import com.mo.domain.Student;
import com.mo.domain.Teacher;
import com.mo.service.IAdminService;
import com.mo.service.IClassService;
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
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: PeiHsien Mo
 * Date: 2019/11/6
 * Time: 19:49
 */
@Controller
@SessionAttributes(value = {"admin"})
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private IAdminService adminService;
    @Autowired
    private ITeacherService teacherService;
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IClassService classService;

    @RequestMapping("/index")
    public String index() {
        return "admin/index";
    }

    @RequestMapping("/info")
    public String info(HttpSession session, Model model) {
        Admin admin = adminService.findById((String) session.getAttribute("userId"));
        admin.setPassword(null);
        model.addAttribute("admin", admin);
        return "admin/info";
    }

    @RequestMapping("/update/{id}")
    public String update(Model model, String verifyInput, HttpSession session, @PathVariable(name = "id") String id, Admin admin, String oldPassword, String rePassword, HttpServletResponse response, HttpServletRequest request) throws Exception {
        if (!verifyInput.toLowerCase().equals(((String) session.getAttribute("verifyCode")).toLowerCase())) {
            return Jump.success(model, "验证码不正确");
        }
        if (!rePassword.equals(admin.getPassword())) {
            return Jump.success(model, "两次输入密码不一致");
        }
        if (admin.getPassword().equals(oldPassword)) {
            return Jump.success(model, "不可以和原密码相同");
        }
        if (!adminService.findById(admin.getAdmin_id()).getPassword().equals(DigestUtils.md5DigestAsHex(oldPassword.getBytes()))) {
            return Jump.success(model, "原密码不正确");
        }
        admin.setAdmin_id(id);
        admin.setPassword(DigestUtils.md5DigestAsHex(admin.getPassword().getBytes()));
        adminService.updateAdmin(admin);
        return Jump.success(model, "修改成功");

    }

    @RequestMapping("/edit")
    public String edit(HttpSession session,Model model) throws Exception {
        Admin admin = adminService.findById((String)session.getAttribute("userId"));
        model.addAttribute("admin", admin);
        return "admin/edit";
    }

    @GetMapping("/teachers")
    public String getAllTeacher(Integer page, Model model) {
//        p.setTotal(teacherService.AllTeacher().size());
//        p.setCurrentPage(page);
//        p.setPageSize(2);
//        p.setLink();
        Page p = new Page(model, page, teacherService.AllTeacher().size(), 10, "/ssm/admin/teachers");
        List<Teacher> teachers = teacherService.AllTeacherByPage(p.getPageSize(), (p.getCurrentPage() - 1) * p.getPageSize());

//        List<Teacher> teachers = teacherService.AllTeacherByPage(2,2*2);
        model.addAttribute("teachers", teachers);
        return "admin/teachers";
    }

    @GetMapping("/students")
    public String getAllStudent(Integer page, Model model) {

        Page p = new Page(model, page, studentService.findAll().size(), 10, "/ssm/admin/students");
        List<Student> students = studentService.findStudentByPage(p.getPageSize(), (p.getCurrentPage() - 1) * p.getPageSize());
        model.addAttribute("students", students);

        return "admin/students";
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("admin/students");
//        modelAndView.addObject("students",students);
//        modelAndView.addObject("page",p);
//        return modelAndView;
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(name = "id") String id, Model model) {
        String result = adminService.deleteUser(id);

        return Jump.success(model, result);


    }


//    @RequestMapping("/allClass")
//    public String AllClass(){
//        List<Class_> classes = classService.findAll();
//        for(Class_ class_:classes){
//
//            System.out.println(class_);
//        }
//        return "success";
//
//    }

//    @RequestMapping("/addClass")
//    public String AddClass(){
//        Class_ class_ = new Class_();
//        class_.setClass_id("171005");
//        class_.setName("17本计算机科学与技术5班");
//        class_.setDepartment("数据科学学院");
//        Integer result = classService.addClass(class_);
//        System.out.println(result);
//        return "success";
//
//    }
//    @RequestMapping("/deleteClass/{id}")
//    public String deleteClass(@PathVariable(name = "id") String id,Model model){
//        String result = classService.deleteClass(id);
//        return Jump.success(model,result);
//    }

    @GetMapping("/studentTemps")
    public String findAllStudentTempByPage(Integer page, Model model) {
        Page p = new Page(model, page, studentService.findAllStudentTemp().size(), 10, "/ssm/admin/studentTemps");
        List<Student> students = studentService.findAllStudentTempByPage(p.getPageSize(), (p.getCurrentPage() - 1) * p.getPageSize());
        model.addAttribute("students", students);
        return "admin/studentTemps";

    }

    @GetMapping("/teacherTemps")
    public String AllTeacherTempByPage(Integer page, Model model) {
//        p.setTotal(teacherService.AllTeacher().size());
//        p.setCurrentPage(page);
//        p.setPageSize(2);
//        p.setLink();
        Page p = new Page(model, page, teacherService.AllTeacherTemp().size(), 10, "/ssm/admin/teacherTemps");
        List<Teacher> teachers = teacherService.AllTeacherTempByPage(p.getPageSize(), (p.getCurrentPage() - 1) * p.getPageSize());

//        List<Teacher> teachers = teacherService.AllTeacherByPage(2,2*2);
        model.addAttribute("teachers", teachers);
        return "admin/teacherTemps";
    }

    @RequestMapping("/addToStudent/{id}")
    public String addToStudent(@PathVariable(name = "id") String id, Model model) {
        String result = studentService.addToStudent(id);
        return Jump.success(model, result);
    }

    @RequestMapping("/deleteStudentTemp/{id}")
    public String deleteStudentTemp(@PathVariable(name = "id") String id, Model model) {
        Integer result = studentService.deleteStudentTemp(id);
        if (result > 0) {
            return Jump.success(model, "删除成功");
        } else {
            return Jump.success(model, "删除失败");
        }

    }

    @RequestMapping("/addToTeacher/{id}")
    public String addToTeacher(@PathVariable(name = "id") String id, Model model) {
        String result = teacherService.AddToTeacher(id);
        return Jump.success(model, result);
    }

    @RequestMapping("/deleteTeacherTemp/{id}")
    public String deleteTeacherTemp(@PathVariable(name = "id") String id, Model model) {
        Integer result = teacherService.deleteTeacherTemp(id);
        if (result > 0) {
            return Jump.success(model, "删除成功");
        } else {
            return Jump.success(model, "删除失败");
        }

    }

    @RequestMapping("/class")
    public String findAll(Model model, Integer page) {
        Page p = new Page(model, page, classService.findAll().size(), 10, "/ssm/admin/class");
        List<Class_> classes = classService.findAllClassByPage(p.getPageSize(), (p.getCurrentPage() - 1) * p.getPageSize());
        model.addAttribute("classes", classes);
        return "admin/class";
    }

    @RequestMapping("/deleteClass/{id}")
    public String deleteClass(Model model, @PathVariable(name = "id") String id) {
        String result = classService.deleteClass(id);
        return Jump.success(model, result);

    }

    @RequestMapping("/classEdit/{id}")
    public String classEditById(Model model, @PathVariable(name = "id") String id) {
        Class_ class_ = classService.findById(id);
        List<Class_> departments = classService.findAllDepartment();
        model.addAttribute("departments", departments);
        model.addAttribute("class_", class_);
        return "admin/classEdit";
    }

    @GetMapping("/addClass")
    public String classEdit(Model model, String id) {
        List<Class_> departments = classService.findAllDepartment();
        model.addAttribute("departments", departments);
        return "admin/addClass";
    }

    @RequestMapping("/saveClass")
    public String addClass(Model model, Class_ class_, String verifyInput, HttpSession session) {
        if (!verifyInput.toLowerCase().equals(((String) session.getAttribute("verifyCode")).toLowerCase())) {
            return Jump.success(model, "验证码不正确");
        }
        Integer result = classService.addClass(class_);
        if (result > 0) {
            return Jump.success(model, "添加成功", "/ssm/admin/class");
        } else {
            return Jump.success(model, "添加失败", "/ssm/admin/class");
        }

    }
    @RequestMapping("/updateClass")
    public String updateClass(Model model, Class_ class_, String verifyInput, HttpSession session) {
        if (!verifyInput.toLowerCase().equals(((String) session.getAttribute("verifyCode")).toLowerCase())) {
            return Jump.success(model, "验证码不正确");
        }
        Integer result = classService.update(class_);
        if (result > 0) {
            return Jump.success(model, "修改成功", "/ssm/admin/class");
        } else {
            return Jump.success(model, "修改失败", "/ssm/admin/class");
        }

    }
}
