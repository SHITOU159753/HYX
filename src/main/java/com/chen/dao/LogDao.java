package com.chen.dao;

import com.chen.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LogDao {
//@Param("username") String userName, @Param("password") String passWord
    Integer examineLogMapper(User user);


    Integer examineUsername(@Param("username") String userName);
}
