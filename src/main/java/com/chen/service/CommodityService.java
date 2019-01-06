package com.chen.service;

import com.chen.pojo.Commodity;
import com.chen.pojo.PageInfo;

import java.util.List;
import java.util.Map;

public interface CommodityService {
//        分页查询
        Map<String,PageInfo> getAllCommodityByPage(Integer pn);

}
