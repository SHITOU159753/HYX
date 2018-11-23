package com.chen.pojo;

/**
 * 产品类
 */
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


    public Commodity() {
    }

    public Commodity(Integer id, String name, String type, Integer sellingPrice, Integer purchasingPrice, Integer sales) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.sellingPrice = sellingPrice;
        this.purchasingPrice = purchasingPrice;
        this.sales = sales;
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

    public Integer getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Integer sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Integer getPurchasingPrice() {
        return purchasingPrice;
    }

    public void setPurchasingPrice(Integer purchasingPrice) {
        this.purchasingPrice = purchasingPrice;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }
}
