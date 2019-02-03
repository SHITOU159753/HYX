package com.chen.common;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer{
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // TODO Auto-generated method stub
        super.onStartup(servletContext);
    }
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppRootConfig.class};
    }
    /**
     * 此方法中负责加载spring mvc 中的v,c等相关组件
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppServletConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[0];
    }
}
