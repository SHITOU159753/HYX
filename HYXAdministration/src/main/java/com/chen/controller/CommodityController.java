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
     *
     * @param pn
     * @return
     */
    @GetMapping("/getCommodityByPage")
    @ResponseBody
    public MSG getAllCommodity(@RequestParam(value = "pn", defaultValue = "1") Integer pn, @RequestParam Integer singlePageDisplay) {
        Map<String, PageInfo> page = commodityService.getAllCommodityByPage(pn, singlePageDisplay, 0, 0, 0);
        return MSG.success(page);
    }

    /**
     * 通过类别ID查询商品详情
     *
     * @return
     */
    @GetMapping("/getMessageByClassId")
    @ResponseBody
    public MSG getMessageByClassId(@RequestParam Integer singlePageDisplay, @RequestParam Integer firstClassId, @RequestParam Integer secondClassId, @RequestParam Integer thirdClassId) {
        Map<String, PageInfo> page = commodityService.getAllCommodityByPage(1, singlePageDisplay, firstClassId, secondClassId, thirdClassId);
        return MSG.success(page);
    }

    /**
     * 通过id获取商品信息
     *
     * @param id
     * @return
     */
    @GetMapping("/getMessageById/{id}")
    @ResponseBody
    public MSG getMessageById(@PathVariable("id") String id) {
        Commodity commodity = commodityService.getMessageBuId(id);
        return MSG.success(commodity);
    }

    /**
     * 修改商品信息
     *
     * @param id
     * @param commodity
     * @return
     */
    @PutMapping("/updateCommodity/{id}")
    @ResponseBody
    public MSG updateCommodity(@PathVariable("id") String id, Commodity commodity) {
        Integer affectNumber = commodityService.updateCommodity(commodity);
        return MSG.success(affectNumber);
    }


    /**
     * 删除商品信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/deleteCommodity/{id}")
    @ResponseBody
    public MSG deleteCommodity(@PathVariable("id") String id) {
        Integer affectNumber = commodityService.deleteCommodity(id);
        return MSG.success(affectNumber);
    }

    /**
     * 添加商品信息
     *
     * @param commodity
     * @return
     */
    @PostMapping("/addEmpmerchandiseMessage")
    @ResponseBody
    public MSG addEmpmerchandiseMessage(Commodity commodity) {
        System.out.println(commodity);
        Integer i = commodityService.addEmpmerchandiseMessage(commodity);
        return MSG.success("影响行数为：" + i);
    }
}
