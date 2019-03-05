package com.chen.utiles;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @chen
 */

public class LogInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws IOException {
        System.out.println("LogInterceptor--->preHandle()执行控制器之前调用此方法....");
        HttpSession   session   =   request.getSession();
        //判断是否已有该用户登录的session
        if(!StringUtils.isEmpty(session.getAttribute("login"))){
            String a= session.getAttribute("login").toString();
            if(a.equals("1")){
                return  true;
            }
        }
        response.sendRedirect("index.html") ;
        //跳转到登录页
        return false;
    }

//    @Override
//    public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object arg2, ModelAndView arg3)
//            throws Exception {
//        System.out.println("LogInterceptor--->postHandle()执行控制器之后且在渲染视图前调用此方法....");
//    }
//    @Override
//    public void afterCompletion(HttpServletRequest req, HttpServletResponse resp, Object arg2, Exception arg3)
//            throws Exception {
//        System.out.println("LogInterceptor--->afterCompletion()执行控制器之后且在完成渲染视图后调用此方法....");
//    }



}
