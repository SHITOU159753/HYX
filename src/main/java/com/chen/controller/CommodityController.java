package com.chen.controller;

import com.chen.pojo.Commodity;
import com.chen.pojo.MSG;
import com.chen.pojo.PageInfo;
import com.chen.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Commodity")
public class CommodityController {

    @Autowired
    CommodityService commodityService;


    @RequestMapping("/getAllCommodity")
    @ResponseBody
    public MSG getAllCommodity(){
        Map<String,PageInfo> page  = commodityService.getAllCommodity();
        return MSG.success(page);
    }


    @RequestMapping("/emp/{commodity}")
    @ResponseBody
    public MSG addCommodity(@PathVariable("commodity") Commodity commodity){
        System.out.println(commodity);

        return  MSG.success();
    }




}
