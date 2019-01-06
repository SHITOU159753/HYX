package com.chen.controller;

import com.chen.pojo.Commodity;
import com.chen.pojo.MSG;
import com.chen.pojo.PageInfo;
import com.chen.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
@RequestMapping("/Commodity")
public class CommodityController {

    @Autowired
    CommodityService commodityService;


    @RequestMapping("/getCommodityByPage")
    @ResponseBody
    public MSG getAllCommodity(@RequestParam(value = "pn", defaultValue = "1")Integer pn){
        Map<String, PageInfo> page  = commodityService.getAllCommodityByPage(pn);
        return MSG.success(page);
    }


}
