package com.chen.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

public interface  ClassDao {


    //一下三个sql获取一二三级分类信息
    List<Map<Integer, String>> getFirstClass();

    List<Map<Integer, String>> getSecondClass(@Param("firstClassID") Integer firstClassID);


    List<Map<Integer, String>> getThirdClass(@Param("secondClassID")Integer secondClassID);

    //修改分类的通用sql
    Integer updateClass(@Param("id") Integer originalId,
                        @Param("name") String updateData,
                        @Param("table") String table);

    //添加一级分类内容
    Integer addFirstClass(@Param("name") String inputVal);

    //添加二三级分类的内容
    Integer addClass(@Param("superiorId") Integer superiorId,
                     @Param("superiorName") String superiorName,
                     @Param("name") String inputVal,
                     @Param("table") String table);

    //删除一二三级分类的数据
    Integer removeClass(@Param("id") Integer id,
                        @Param("table") String tableName);


}
