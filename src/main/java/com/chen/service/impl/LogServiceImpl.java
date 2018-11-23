package com.chen.service.impl;

import com.chen.dao.LogDao;
import com.chen.pojo.User;
import com.chen.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    LogDao logDao;

    @Override
    public Integer examineLogService(User user) {
        String userName = user.getUsername();
        String passWord = user.getPassword();

        return logDao.examineLogMapper(userName,passWord);
    }

    @Override
    public Integer examineUsername(String userName) {

        return logDao.examineUsername(userName);
    }
}
