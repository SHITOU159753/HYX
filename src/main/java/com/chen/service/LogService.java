package com.chen.service;

import com.chen.pojo.MSG;
import com.chen.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LogService {
    MSG examineLogService(User user);

    Integer examineUsername(String userName);
}
