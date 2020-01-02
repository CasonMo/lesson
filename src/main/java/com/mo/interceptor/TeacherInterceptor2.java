package com.mo.interceptor;


import com.mo.domain.Lesson;
import com.mo.service.ILessonService;
import com.mo.service.IStudentService;
import com.mo.service.ITeacherService;
import com.mo.tools.Jump;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: PeiHsien Mo
 * Date: 2019/12/26
 * Time: 23:16
 */
public class TeacherInterceptor2 implements HandlerInterceptor {
    @Autowired
    private ITeacherService teacherService;
    @Autowired
    private ILessonService lessonService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取session
        HttpSession session = request.getSession();
        NativeWebRequest webRequest = new ServletWebRequest(request);
        Map<String,String> map =(Map<String, String>) webRequest.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE,RequestAttributes.SCOPE_REQUEST);
        Lesson lesson = lessonService.findLessonInfoByLessonIDAndTeachId((String)session.getAttribute("userId"),map.get("id"));
        if(lesson==null){
            request.setAttribute("msg", "你无权访问此页面");
            request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
            return false;
        } else {
            return true;
        }

    }

}
