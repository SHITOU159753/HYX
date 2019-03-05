package com.chen.service.impl;

import com.chen.dao.LogDao;
import com.chen.pojo.MSG;
import com.chen.pojo.User;
import com.chen.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            throw new RuntimeException("账号密码错误");
        }

        //将数据存储到session中
        HttpSession session=request.getSession();
        session.setAttribute("login", i);
        return MSG.success();
    }

    @Override
    public Integer examineUsername(String userName) {

        return logDao.examineUsername(userName);
    }
}
