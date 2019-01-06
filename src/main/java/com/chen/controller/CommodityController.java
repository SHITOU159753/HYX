package com.chen.controller;

import com.chen.pojo.Commodity;
import com.chen.pojo.MSG;
import com.chen.pojo.PageInfo;
import com.chen.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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


    @RequestMapping(value = "/emp",method = RequestMethod.POST)
    @ResponseBody
    public MSG addCommodity( Commodity commodity){
        System.out.println(commodity);

        return  MSG.success();
    }




}
