package com.cskaoyan.sb.springboot_project.bean;

public class GoodsList {
    String goodsName;
    int id;
    int number;
    String picUrl;

    public GoodsList() {
    }

    public GoodsList(String goodsName, int id, int number, String picUrl) {
        this.goodsName = goodsName;
        this.id = id;
        this.number = number;
        this.picUrl = picUrl;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @Override
    public String toString() {
        return "GoodsList{" +
                "goodsName='" + goodsName + '\'' +
                ", id=" + id +
                ", number=" + number +
                ", picUrl='" + picUrl + '\'' +
                '}';
    }
}
