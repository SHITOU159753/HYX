package com.chen.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * 产品类
 */
@Getter
@Setter

public class Commodity {


    private Integer id;
    //产品名称
    private String name;
    //产品型号
    private String type;
    //产品售价
    private Integer sellingPrice;
    //产品进价
    private Integer purchasingPrice;
    //销量
    private Integer sales;
    //商品总利润
    private Integer grossProfit;
    //商品单件利润
    private Integer IndividualProfit;
    //一级分类
    private Integer firstClassification;
    //二级分类
    private Integer secondClassification;
    //三级分类
    private Integer thirdClassification;
    //一级分类
    private String firstClassificationName;
    //二级分类
    private String secondClassificationName;
    //三级分类
    private String thirdClassificationName;


    public Commodity() {
    }


    public Commodity(Integer id, String name, String type, Integer sellingPrice, Integer purchasingPrice, Integer sales, Integer grossProfit, Integer individualProfit, Integer firstClassification, Integer secondClassification, Integer thirdClassification, String firstClassificationName, String secondClassificationName, String thirdClassificationName) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.sellingPrice = sellingPrice;
        this.purchasingPrice = purchasingPrice;
        this.sales = sales;
        this.grossProfit = grossProfit;
        IndividualProfit = individualProfit;
        this.firstClassification = firstClassification;
        this.secondClassification = secondClassification;
        this.thirdClassification = thirdClassification;
        this.firstClassificationName = firstClassificationName;
        this.secondClassificationName = secondClassificationName;
        this.thirdClassificationName = thirdClassificationName;
    }
}
