package com.chen.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LogDao {

    Integer examineLogMapper(@Param("username") String userName, @Param("password") String passWord);


    Integer examineUsername(@Param("username") String userName);
}
