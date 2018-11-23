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

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Commodity")
public class CommodityController {

    @Autowired
    CommodityService commodityService;


    @RequestMapping("/getAllCommodity")
    @ResponseBody
    public MSG getAllCommodity(@RequestParam(value = "pn" ,defaultValue = "1") Integer pn){
        PageInfo page  = commodityService.getAllCommodity(pn);
        return MSG.success().add("pageInfo",page);
    }

}
