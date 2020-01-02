package com.mo.controller;

import com.mo.dao.ITeacherDao;
import com.mo.domain.Admin;
import com.mo.domain.Class_;
import com.mo.domain.Student;
import com.mo.domain.Teacher;
import com.mo.service.IAdminService;
import com.mo.service.IClassService;
import com.mo.service.IStudentService;
import com.mo.service.ITeacherService;
import com.mo.tools.SendMail;
import com.mo.tools.VerifyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: PeiHsien Mo
 * Date: 2019/11/7
 * Time: 14:10
 */
@Controller
@SessionAttributes(value = {"userName","userId","msg"})
public class LoginController {

    @Autowired
    private IAdminService adminService;
    @Autowired
    private IStudentService studentService;
    @Autowired
    private ITeacherService teacherService;
    @Autowired
    private IClassService classService;
    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("pageTitle","登录");
        return "login";
    }



    @RequestMapping("/logout")
    public String logout(HttpSession session,Model model){
        session.invalidate();
        model.addAttribute("pageTitle","注销登录");
        return "logout";
    }
    @RequestMapping("/sendMail")
    public void sendMail(HttpSession session,Model model){
        SendMail.sendMail("806754563@qq.com", "1234");

    }

    @RequestMapping("/check")
    public void find(String id, String password,String verifyInput, HttpSession session, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if(!verifyInput.toLowerCase().equals(((String)session.getAttribute("verifyCode")).toLowerCase())){
            model.addAttribute("msg","验证码不正确");
            response.sendRedirect(request.getContextPath()+"/login");
        }else {
            Admin admin = adminService.find(id, password);
            Student student = studentService.find(id, password);
            Teacher teacher = teacherService.find(id, password);
            if (admin != null) {
                model.addAttribute("userId", admin.getAdmin_id());
                model.addAttribute("userName", admin.getName());
                response.sendRedirect(request.getContextPath() + "/admin/index");

            } else if (student != null) {
                model.addAttribute("userId", student.getStu_id());
                model.addAttribute("userName", student.getName());
                response.sendRedirect(request.getContextPath() + "/student/index");
            } else if (teacher != null) {
                model.addAttribute("userId", teacher.getTeach_id());
                model.addAttribute("userName", teacher.getName());
                response.sendRedirect(request.getContextPath() + "/teacher/index");
            } else {
                model.addAttribute("msg", "账号密码不正确");
                response.sendRedirect(request.getContextPath() + "/login");
            }
        }

    }


    /* 获取验证码图片*/

    @RequestMapping(value = "/getVerifyCode")
    public void getVerificationCode(HttpServletResponse response,HttpServletRequest request) {

        try {

            int width=200;

            int height=75;

            BufferedImage verifyImg=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

//生成对应宽高的初始图片

            String randomText = VerifyCode.drawRandomText(width,height,verifyImg);

//单独的一个类方法，出于代码复用考虑，进行了封装。

//功能是生成验证码字符并加上噪点，干扰线，返回值为验证码字符

            request.getSession().setAttribute("verifyCode", randomText);

            response.setContentType("image/png");//必须设置响应内容类型为图片，否则前台不识别

            OutputStream os = response.getOutputStream(); //获取文件输出流

            ImageIO.write(verifyImg,"png",os);//输出图片流

            os.flush();

            os.close();//关闭流

        } catch (IOException e) {

            System.out.println(e.getMessage());

            e.printStackTrace();

        }

    }

}
