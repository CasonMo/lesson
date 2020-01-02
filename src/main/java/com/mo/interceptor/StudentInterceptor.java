package com.mo.interceptor;

import com.mo.service.IStudentService;
import com.mo.tools.Jump;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by IntelliJ IDEA.
 * User: PeiHsien Mo
 * Date: 2019/12/25
 * Time: 19:31
 */
public class StudentInterceptor implements HandlerInterceptor {
    @Autowired
    private IStudentService studentService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取session
        HttpSession session = request.getSession();
        if(studentService.findById((String)session.getAttribute("userId"))==null){
            //不符合条件的给出提示信息，并转发到登录页面
            request.setAttribute("msg", "你无权访问此页面");
            request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
            return false;
        }else {
            return true;
        }

    }
}
