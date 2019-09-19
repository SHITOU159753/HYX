package com.chen.serviceImpl;

import com.chen.dao.CommodityDao;
import com.chen.pojo.Commodity;
import com.chen.pojo.PageInfo;
import com.chen.service.ClassService;
import com.chen.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    CommodityDao commodityDao;

    @Autowired
    ClassService classService;

    /**
     * 查询分页
     * @return
     */
    @Override
    public  Map<String,PageInfo> getAllCommodityByPage(Integer pn,Integer singlePageDisplay,Integer firstClassification,Integer secondClassification,Integer thirdClassification) {

        //查询总数
        Integer sum = commodityDao.getAllCommoditySize(firstClassification,secondClassification,thirdClassification);
        //查询分页信息
        List<Commodity> listCommodity = commodityDao.getLimitCommodity((pn-1)*singlePageDisplay,singlePageDisplay,firstClassification,secondClassification,thirdClassification);
        int pages = 0;
        if(sum>singlePageDisplay){
            double pagesDouble = Math.ceil((double)sum/singlePageDisplay);
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
        //预计售价减去进价
        BigDecimal individualProfit = commodity.getSellingPrice().subtract(commodity.getPurchasingPrice());
        commodity.setIndividualProfit(individualProfit);
        return commodityDao.addEmpmerchandiseMessage(commodity);
    }

    @Override
    public Commodity getMessageBuId(String id) {
        return commodityDao.getMessageBuId(id);
    }

    @Override
    public Integer updateCommodity(Commodity commodity) {
        return commodityDao.updateCommodity(commodity);
    }

    @Override
    public Integer deleteCommodity(String id) {

        return commodityDao.deleteCommodity(id);
    }


}
