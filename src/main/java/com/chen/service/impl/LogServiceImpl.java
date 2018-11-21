package com.chen.service.impl;

import com.chen.dao.LogDao;
import com.chen.pojo.StudentProperties;
import com.chen.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    LogDao logDao;

    @Override
    public Integer examineLogService(StudentProperties student) {
        String username = student.getUsername();
        String password = student.getPassword();

        return logDao.examineLogMapper(username,password);
    }
}
