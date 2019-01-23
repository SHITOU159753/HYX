package com.chen.service;

import com.chen.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LogService {
    Integer examineLogService(User user);

    Integer examineUsername(String userName);
}
