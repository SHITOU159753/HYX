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

}
