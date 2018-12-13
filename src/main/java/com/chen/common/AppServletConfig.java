package com.chen.common;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.context.annotation.FilterType;

@ComponentScan(value="com.chen", includeFilters={ @Filter(type=FilterType.ANNOTATION,classes={Controller.class})}, useDefaultFilters=false)
@EnableWebMvc//启用spring mvc 默认配置
public class AppServletConfig extends WebMvcConfigurationSupport {
    /**配置视图解析器*/
    @Override
    public void configureViewResolvers(
            ViewResolverRegistry registry) {
        registry.jsp(
                "/WEB-INF/pages/",
                ".html");
    }
}
