package com.chen.controller;

import com.chen.pojo.MSG;
import com.chen.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ClassController")
public class ClassController {

    @Autowired
    ClassService classService;


    /**
     * 获取所有一级分类的信息
     *
     * @return
     */
    @GetMapping("/getAllFirstClassification")
    @ResponseBody
    public MSG getAllFirstClassification() {
        return classService.getAllFirstClassification();
    }

    /**
     * 获取所有二级分类的信息
     *
     * @return
     */
    @GetMapping("/getAllSecondClassification/{firstClassID}")
    @ResponseBody
    public MSG getAllSecondClassification(@PathVariable("firstClassID") Integer firstClassID) {
        return classService.getAllSecondClassification(firstClassID);
    }

    /**
     * 获取所有三级分类的信息
     *
     * @return
     */
    @GetMapping("/getAllThirdClassification/{secondClassID}")
    @ResponseBody
    public MSG getAllThirdClassification(@PathVariable("secondClassID") Integer secondClassID) {
        return classService.getAllThirdClassification(secondClassID);
    }

    /**
     * 修改多级分类通用方法
     *
     * @param originalId 要修改原分类的id
     * @param updateData 修改后的内容
     * @param className  几级分类
     * @return
     */
    @PostMapping("/updateClass")
    @ResponseBody
    public MSG updateClass(@RequestParam("originalId") Integer originalId,
                           @RequestParam("updateData") String updateData,
                           @RequestParam("className") String className) {
        return classService.updateClass(originalId, updateData, className);
    }

    /**
     * 添加分类的方法
     *
     * @param superiorId 上级分类的id
     * @param inputVal   添加的内容
     * @param className  几级分类
     * @return
     */
    @PostMapping("/addClass")
    @ResponseBody
    public MSG addClass(@RequestParam("superiorId") Integer superiorId,
                        @RequestParam("inputVal") String inputVal,
                        @RequestParam("className") String className) {
        return classService.addClass(superiorId, inputVal, className);
    }


    @PostMapping("/removeClass")
    @ResponseBody
    public MSG removeClass(@RequestParam("id") Integer id, @RequestParam("className") String className) {
        return classService.removeClass(id, className);
    }


}
