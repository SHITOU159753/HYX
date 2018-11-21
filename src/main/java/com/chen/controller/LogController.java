package com.chen.controller;

import com.chen.pojo.MSG;
import com.chen.pojo.StudentProperties;
import com.chen.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/LogController")
public class LogController {

    @Autowired
    LogService logService;


    @RequestMapping("/log")
    @ResponseBody
    public MSG log(StudentProperties student){
        Integer a = logService.examineLogService(student);
        if(a != 1){
            return MSG.fail();
        }
        return MSG.success();
    }
}
