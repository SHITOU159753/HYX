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


    /**
     * 分页查找商品信息
     * @param pn
     * @return
     */
    @GetMapping("/getCommodityByPage")
    @ResponseBody
    public MSG getAllCommodity(@RequestParam(value = "pn", defaultValue = "1")Integer pn){
        Map<String, PageInfo> page  = commodityService.getAllCommodityByPage(pn);
        return MSG.success(page);
    }

    @GetMapping("/emp/{id}")
    @ResponseBody
    public MSG getMessageBuId(@PathVariable("id")  String id){
        Commodity commodity = commodityService.getMessageBuId(id);
        return  MSG.success(commodity);
    }

    @PutMapping("/updateCommodity/{id}")
    @ResponseBody
    public MSG updateCommodity(@PathVariable("id")  String id,Commodity commodity){
        Integer affectNumber = commodityService.updateCommodity(commodity);
        return  MSG.success(affectNumber);
    }


    /**
     * 添加商品信息
     * @param commodity
     * @return
     */
    @PostMapping("/addEmpmerchandiseMessage")
    @ResponseBody
    public MSG addEmpmerchandiseMessage(Commodity commodity){
        System.out.println(commodity);
        Integer i = commodityService.addEmpmerchandiseMessage(commodity);
        return MSG.success("影响行数为："+ i);
    }
}
