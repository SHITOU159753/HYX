package com.chen.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LogDao {

    int examineLogMapper(@Param("username") String username, @Param("password") String password);




}
