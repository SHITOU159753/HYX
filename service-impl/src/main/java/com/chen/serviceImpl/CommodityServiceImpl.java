package com.chen.service.impl;

import com.chen.dao.CommodityDao;
import com.chen.pojo.Commodity;
import com.chen.pojo.PageInfo;
import com.chen.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    CommodityDao commodityDao;


    /**
     * 查询分页
     * @return
     */
    @Override
    public  Map<String,PageInfo> getAllCommodityByPage(Integer pn) {

        //查询总数
        Integer sum = commodityDao.getAllCommoditySize();
        //查询分页信息
        List<Commodity> listCommodity = commodityDao.getLimitCommodity((pn-1)*8,8);
        int pages = 0;
        if(sum>8){
            double pagesDouble = Math.ceil((double)sum/8);
            pages = (new Double(pagesDouble)).intValue();
        }else{
            pages = 1;
        }
        int[] navigatepageNums = new int [pages];
        for (int i = 0;i<pages;i++){
            navigatepageNums[i] = i + 1;
        }
        PageInfo page= new PageInfo(pn,pages,sum,listCommodity,pn == 1?false:true,pn == pages?false:true,navigatepageNums);
        Map<String,PageInfo> pageMap = new HashMap<>();
        pageMap.put("pageInfo",page);
        return pageMap;
    }

    /**
     * 添加商品信息表
     * @param commodity
     */
    @Override
    public Integer addEmpmerchandiseMessage(Commodity commodity) {
        return commodityDao.addEmpmerchandiseMessage(commodity.getName(),commodity.getType(),commodity.getSellingPrice(),commodity.getPurchasingPrice(),commodity.getSales());
    }

    @Override
    public Commodity getMessageBuId(String id) {
        return commodityDao.getMessageBuId(id);
    }

    @Override
    public Integer updateCommodity(Commodity commodity) {
        return commodityDao.updateCommodity(commodity);
    }


}
