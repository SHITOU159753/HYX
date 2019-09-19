package com.chen.pojo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

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



    //产品进价
    private BigDecimal purchasingPrice;
    //销量
    private Integer sales;
    //预计产品售价
    private BigDecimal sellingPrice;
    //预计商品单件利润
    private BigDecimal IndividualProfit;
    //预计商品总利润
    private BigDecimal grossProfit;
    //实际商品总利润
    private BigDecimal realityGrossProfit;

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

    public Commodity(Integer id, String name, String type, BigDecimal purchasingPrice, Integer sales, BigDecimal sellingPrice, BigDecimal individualProfit, BigDecimal grossProfit, BigDecimal realityGrossProfit, Integer firstClassification, Integer secondClassification, Integer thirdClassification, String firstClassificationName, String secondClassificationName, String thirdClassificationName) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.purchasingPrice = purchasingPrice;
        this.sales = sales;
        this.sellingPrice = sellingPrice;
        IndividualProfit = individualProfit;
        this.grossProfit = grossProfit;
        this.realityGrossProfit = realityGrossProfit;
        this.firstClassification = firstClassification;
        this.secondClassification = secondClassification;
        this.thirdClassification = thirdClassification;
        this.firstClassificationName = firstClassificationName;
        this.secondClassificationName = secondClassificationName;
        this.thirdClassificationName = thirdClassificationName;
    }
}
