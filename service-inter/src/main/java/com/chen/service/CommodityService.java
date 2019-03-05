package com.chen.service;


import com.chen.pojo.Commodity;
import com.chen.pojo.PageInfo;

import java.util.Map;

public interface CommodityService {
//        分页查询
    Map<String, PageInfo> getAllCommodityByPage(Integer pn);
//
    Integer addEmpmerchandiseMessage(Commodity commodity);

    Commodity getMessageBuId(String id);

    Integer updateCommodity(Commodity commodity);

    Integer deleteCommodity(String id);
}
