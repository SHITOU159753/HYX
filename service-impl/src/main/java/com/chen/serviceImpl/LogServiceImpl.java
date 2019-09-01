package com.chen.service.impl;

import com.chen.dao.LogDao;
import com.chen.pojo.MSG;
import com.chen.pojo.User;
import com.chen.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    LogDao logDao;

    @Autowired
    HttpServletRequest request;

    @Override
    public MSG examineLogService(User user) {
//        String md5PassWord = DigestUtils.md5Hex(user.getPassword());
//        user.setPassword(md5PassWord);
        Integer i = logDao.examineLogMapper(user);
        if(i != 1){
            return MSG.fail("账号密码错误");
        }

        // 存入
//        Cookie cookie = new Cookie("LOGIN",user.getUsername());
//        Cookie("controllerSetCookie","这是我通过后台添加的cookie");
        //设置cookie的生命周期，如果为负值的话，关闭浏览器就失效
//        cookie.setMaxAge(60*60*24*365);
        // 设置Cookie路径,不设置的话为当前路径(对于Servlet来说为request.getContextPath() + web.xml里配置的该Servlet的url-pattern路径部分)
        //cookie.setPath("/");
//        response.addCookie(cookie);
        //将数据存储到session中
        HttpSession session=request.getSession();
        session.setAttribute("LOGIN", i);
        return MSG.success(user.getUsername());
    }

    @Override
    public Integer examineUsername(String userName) {

        return logDao.examineUsername(userName);
    }
}
