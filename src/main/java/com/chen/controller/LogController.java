package com.chen.controller;

import com.chen.pojo.MSG;
import com.chen.pojo.User;
import com.chen.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.*;

@Controller
@RequestMapping("/LogController")
public class LogController {

    @Autowired
    LogService logService;

    /**
     * post提交错误问题解决，使用form表单ajax提交时提交按钮应使用button，不应使用subbmit
     *
     * cookie和session有问题，具体问题：1.第一次输入密码登陆后显示post提交错误，2.这个时候session应该已经存进去了，但是浏览器看不到，第二次进去的时候就好了
     * 拦截器，格式还是不清楚
     *
     * 查阅资料session和cooke的资料
     * @param user
     * @param request
     * @param response
     * @return ,method = {RequestMethod.POST}
     */
    @RequestMapping(value ="/log")
    @ResponseBody
    public MSG log(User user,HttpServletRequest request, HttpServletResponse response){

        Integer a = logService.examineLogService(user);
        if(a != 1){
            return MSG.fail();
        }
        //将数据存储到session中
        HttpSession session=request.getSession();
        session.setAttribute("login", a);
        Cookie cookie=new Cookie("JSESSIONID", session.getId());
        //设置cookie保存时间
        cookie.setMaxAge(60);
        //被创建的cookie返回浏览器
        response.addCookie(cookie);
        return MSG.success();
    }

    @RequestMapping("/checkuser")
    @ResponseBody
    public MSG checkuser(String userName){
        Integer a = logService.examineUsername(userName);
        if(a != 0){
            return MSG.fail();
        }
        return MSG.success();
    }


}
