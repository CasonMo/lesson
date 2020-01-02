package com.mo.interceptor;

import com.mo.domain.Admin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by IntelliJ IDEA.
 * User: PeiHsien Mo
 * Date: 2019/11/4
 * Time: 12:50
 */
public class MyInterceptor implements HandlerInterceptor {
    // 在业务处理器处理请求之前被调用
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取session
        HttpSession session = request.getSession();

        //判断session中是否有用户数据，如果有，则返回true，继续向下执行
        if (session.getAttribute("userId") != null && session.getAttribute("userId") != "") {
            return true;
        }
        //不符合条件的给出提示信息，并转发到登录页面
        request.setAttribute("msg", "您还没有登录，请先登录！");
        request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
        return false;
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
    }
//    // 在业务处理器处理请求完成之后，生成视图之前执行
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//
//        System.out.println("postHandle执行了...");
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
//
//    }
//    // 在DispatcherServlet完全处理完请求之后被调用，可用于清理资源
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("afterCompletion执行了...");
//    }
}
