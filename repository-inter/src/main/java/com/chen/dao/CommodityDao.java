package com.chen.dao;

import com.chen.pojo.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommodityDao {

    List<Commodity> getLimitCommodity(@Param("start") Integer start,@Param("size") Integer size );

    Integer getAllCommoditySize();

    Integer addEmpmerchandiseMessage(@Param("name")String name,
                                     @Param("type")String type,
                                     @Param("sellingPrice") Integer sellingPrice,
                                     @Param("purchasingPrice") Integer purchasingPrice,
                                     @Param("sales") Integer sales);

    Commodity getMessageBuId(@Param("id") String id);

    Integer updateCommodity(Commodity commodity);
}
