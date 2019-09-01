package com.chen.utiles;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @chen
 */
@Component

public class LogInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException, ServletException {
        System.out.println("LogInterceptor--->preHandle()执行控制器之前调用此方法....");

//        Cookie [] cookies = request.getCookies();
//        for (int i = 0; i < cookies.length; i++){
//            if("LOGIN".equals(cookies[i].getName())){
//
//            }
//        }
        HttpSession   session   =   request.getSession();
        //判断是否已有该用户登录的session
        if(!StringUtils.isEmpty(session.getAttribute("LOGIN"))){
            String a= session.getAttribute("LOGIN").toString();
            if(a.equals("1")){
                return  true;
            }
        }
        response.sendRedirect("/login.html") ;
        //跳转到登录页
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object arg2, ModelAndView arg3)
            throws Exception {
//        System.out.println("LogInterceptor--->postHandle()执行控制器之后且在渲染视图前调用此方法....");
    }
    @Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse resp, Object arg2, Exception arg3)
            throws Exception {
//        System.out.println("LogInterceptor--->afterCompletion()执行控制器之后且在完成渲染视图后调用此方法....");
    }



}
