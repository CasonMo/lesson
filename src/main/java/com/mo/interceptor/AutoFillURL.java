package com.mo.interceptor;

import com.mo.tools.ClassAndMethods;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 * User: PeiHsien Mo
 * Date: 2019/11/28
 * Time: 0:18
 */
public class AutoFillURL implements HandlerInterceptor {


    // 在业务处理器处理请求完成之后，生成视图之前执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println(ClassAndMethods.getCM(getClass()));
        response.sendRedirect(request.getContextPath()+ ClassAndMethods.getCM(getClass()));
    }
}
