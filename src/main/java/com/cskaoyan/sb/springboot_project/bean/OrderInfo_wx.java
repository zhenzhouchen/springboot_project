package com.cskaoyan.sb.springboot_project.bean;

import java.util.Arrays;

public class OrderInfo_wx {
    double actualPrice;
    GoodsList[] goodsList;
    HandleOption handleOption;
    int id;
    boolean isGroupin;
    String orderSn;
    int orderStatus;
    String orderStatusText;

    public OrderInfo_wx() {
    }

    public OrderInfo_wx(double actualPrice, GoodsList[] goodsList, HandleOption handleOption, int id, boolean isGroupin, String orderSn, int orderStatus, String orderStatusText) {
        this.actualPrice = actualPrice;
        this.goodsList = goodsList;
        this.handleOption = handleOption;
        this.id = id;
        this.isGroupin = isGroupin;
        this.orderSn = orderSn;
        this.orderStatus = orderStatus;
        this.orderStatusText = orderStatusText;
    }

    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public GoodsList[] getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(GoodsList[] goodsList) {
        this.goodsList = goodsList;
    }

    public HandleOption getHandleOption() {
        return handleOption;
    }

    public void setHandleOption(HandleOption handleOption) {
        this.handleOption = handleOption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isGroupin() {
        return isGroupin;
    }

    public void setGroupin(boolean groupin) {
        isGroupin = groupin;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusText() {
        return orderStatusText;
    }

    public void setOrderStatusText(String orderStatusText) {
        this.orderStatusText = orderStatusText;
    }

    @Override
    public String toString() {
        return "OrderInfo_wx{" +
                "actualPrice=" + actualPrice +
                ", goodsList=" + Arrays.toString(goodsList) +
                ", handleOption=" + handleOption +
                ", id=" + id +
                ", isGroupin=" + isGroupin +
                ", orderSn='" + orderSn + '\'' +
                ", orderStatus=" + orderStatus +
                ", orderStatusText='" + orderStatusText + '\'' +
                '}';
    }
}
