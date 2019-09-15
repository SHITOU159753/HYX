package com.chen.service;

import com.chen.pojo.MSG;

public interface ClassService {
    /**
     * 获取所有一级分类的信息
     *
     * @return
     */
    MSG getAllFirstClassification();

    /**
     * 获取所有二级分类的信息
     *
     * @return
     */
    MSG getAllSecondClassification(Integer firstClassID);

    /**
     * 获取所有三级分类的信息
     *
     * @return
     */
    MSG getAllThirdClassification(Integer secondClassID);

    /**
     * 修改多级分类通用方法
     *
     * @param originalId 要修改原分类的id
     * @param updateData 修改后的内容
     * @param className  几级分类
     * @return
     */
    MSG updateClass(Integer originalId, String updateData, String className);

    /**
     * 添加分类的方法
     *
     * @param superiorId 上级分类的id
     * @param inputVal   添加的内容
     * @param className  几级分类
     * @return
     */
    MSG addClass(Integer superiorId, String inputVal, String className);

    /**
     * 删除分类方法
     * @param id
     * @param className
     * @return
     */
    MSG removeClass(Integer id, String className);





}
