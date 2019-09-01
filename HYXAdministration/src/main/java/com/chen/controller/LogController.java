package com.chen.controller;

import com.chen.pojo.MSG;
import com.chen.pojo.User;
import com.chen.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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
     * @param user
     * @return , method = {RequestMethod.POST}
     */
    @RequestMapping(value = "/log")
    @ResponseBody
    public MSG log(User user) {
        MSG msg = logService.examineLogService(user);
        return msg;
    }

    @RequestMapping("/checkuser")
    @ResponseBody
    public MSG checkuser(String userName) {
        Integer a = logService.examineUsername(userName);
        if (a != 0) {
            return MSG.fail("姓名已存在！");
        }
        return MSG.success();
    }


}
