package com.chen.bean;

import com.chen.utiles.LogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private LogInterceptor myLogInterceptor;

    //重写添加拦截器的方法(添加调用的拦截器，并指定拦截的目标)
    @Override
    public void addInterceptors(InterceptorRegistry registry) { //注册拦截器
        //代表指定拦截所有路径的资源.并且排除掉xxx（不拦截xxx）
        //registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("xxx");
        //addPathPatterns("/**")代表指定拦截所有路径的资源

        registry.addInterceptor(myLogInterceptor).addPathPatterns("/*.html").addPathPatterns("/Commodity/*").excludePathPatterns("/login.html", "/register.html");


    }




}
