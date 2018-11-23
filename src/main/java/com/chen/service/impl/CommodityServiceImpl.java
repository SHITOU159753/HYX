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
     * @param pn
     * @return
     */
    @Override
    public PageInfo getAllCommodity(Integer pn) {

        //查询总数
        Integer sum = commodityDao.getAllCommoditySize();
        //查询分页信息
        List<Commodity> listCommodity = commodityDao.getLimitCommodity((pn-1)*5 ,5);
        double pagesDouble = Math.ceil((double)sum/5);
        int pages = (new Double(pagesDouble)).intValue();
        int[] navigatepageNums = new int [pages];
        for (int i = 0;i<pages;i++){
            navigatepageNums[i] = i + 1;
        }
        PageInfo page= new PageInfo(pn,pages,sum,listCommodity,pn == 1?false:true,pn == pages?false:true,navigatepageNums);

        return page;
    }

}
