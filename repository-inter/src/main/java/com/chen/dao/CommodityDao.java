package com.chen.dao;

import com.chen.pojo.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommodityDao {
    /**
     * 查询分页
     * @return
     */
    List<Commodity> getLimitCommodity(@Param("start") Integer start,
                                      @Param("size") Integer size,
                                      @Param("firstClassification") Integer firstClassification,
                                      @Param("secondClassification") Integer secondClassification,
                                      @Param("thirdClassification") Integer thirdClassification);

    /**
     * 获取商品的数量
     * @return
     */
    Integer getAllCommoditySize( @Param("firstClassification") Integer firstClassification,
                                 @Param("secondClassification") Integer secondClassification,
                                 @Param("thirdClassification") Integer thirdClassification);

    /**
     * 通过id获取商品信息
     *
     * @param id
     * @return
     */
    Commodity getMessageBuId(@Param("id") String id);
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
    Integer deleteCommodity(@Param("id") String id);

    /**
     * 添加商品信息表
     * @param commodity
     */
    Integer addEmpmerchandiseMessage(Commodity commodity);
}
