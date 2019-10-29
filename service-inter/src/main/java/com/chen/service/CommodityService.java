package com.chen.service;


import com.chen.pojo.Commodity;
import com.chen.pojo.PageInfo;

import java.util.Map;

public interface CommodityService {
    /**
     * 查询分页
     * @return
     */
    Map<String, PageInfo> getAllCommodityByPage(Integer pn, Integer singlePageDisplay,Integer firstClassification,Integer secondClassification,Integer thirdClassification);

    /**
     * 通过id获取商品信息
     *
     * @param id
     * @return
     */
    Commodity getMessageById(String id);

    /**
     * 修改商品信息
     *
     * @param commodity
     * @return
     */
    Integer updateCommodity(Commodity commodity);

    /**
     * 删除商品信息
     *
     * @param id
     * @return
     */
    Integer deleteCommodity(String id);

    /**
     * 添加商品信息表
     * @param commodity
     */
    Integer addEmpmerchandiseMessage(Commodity commodity);
}
