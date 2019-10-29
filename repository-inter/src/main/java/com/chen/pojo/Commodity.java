package com.chen.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 产品类
 */


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

    private Integer style;
    private Date createAt;
    private Date updateAt;
    private Date deleteAt;

    //一级分类
    private String firstClassificationName;
    //二级分类
    private String secondClassificationName;
    //三级分类
    private String thirdClassificationName;


    public Commodity() {
    }

    public Commodity(Integer id, String name, String type, BigDecimal purchasingPrice, Integer sales, BigDecimal sellingPrice, BigDecimal individualProfit, BigDecimal grossProfit, BigDecimal realityGrossProfit, Integer firstClassification, Integer secondClassification, Integer thirdClassification, Integer style, Date createAt, Date updateAt, Date deleteAt, String firstClassificationName, String secondClassificationName, String thirdClassificationName) {
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
        this.style = style;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.deleteAt = deleteAt;
        this.firstClassificationName = firstClassificationName;
        this.secondClassificationName = secondClassificationName;
        this.thirdClassificationName = thirdClassificationName;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPurchasingPrice() {
        return purchasingPrice;
    }

    public void setPurchasingPrice(BigDecimal purchasingPrice) {
        this.purchasingPrice = purchasingPrice;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public BigDecimal getIndividualProfit() {
        return IndividualProfit;
    }

    public void setIndividualProfit(BigDecimal individualProfit) {
        IndividualProfit = individualProfit;
    }

    public BigDecimal getGrossProfit() {
        return grossProfit;
    }

    public void setGrossProfit(BigDecimal grossProfit) {
        this.grossProfit = grossProfit;
    }

    public BigDecimal getRealityGrossProfit() {
        return realityGrossProfit;
    }

    public void setRealityGrossProfit(BigDecimal realityGrossProfit) {
        this.realityGrossProfit = realityGrossProfit;
    }

    public Integer getFirstClassification() {
        return firstClassification;
    }

    public void setFirstClassification(Integer firstClassification) {
        this.firstClassification = firstClassification;
    }

    public Integer getSecondClassification() {
        return secondClassification;
    }

    public void setSecondClassification(Integer secondClassification) {
        this.secondClassification = secondClassification;
    }

    public Integer getThirdClassification() {
        return thirdClassification;
    }

    public void setThirdClassification(Integer thirdClassification) {
        this.thirdClassification = thirdClassification;
    }

    public Integer getStyle() {
        return style;
    }

    public void setStyle(Integer style) {
        this.style = style;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(Date deleteAt) {
        this.deleteAt = deleteAt;
    }

    public String getFirstClassificationName() {
        return firstClassificationName;
    }

    public void setFirstClassificationName(String firstClassificationName) {
        this.firstClassificationName = firstClassificationName;
    }

    public String getSecondClassificationName() {
        return secondClassificationName;
    }

    public void setSecondClassificationName(String secondClassificationName) {
        this.secondClassificationName = secondClassificationName;
    }

    public String getThirdClassificationName() {
        return thirdClassificationName;
    }

    public void setThirdClassificationName(String thirdClassificationName) {
        this.thirdClassificationName = thirdClassificationName;
    }
}
