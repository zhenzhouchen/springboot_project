package com.cskaoyan.sb.springboot_project.bean;

import java.math.BigDecimal;

public class CartTotalCount {
    //选中商品总价格
    private BigDecimal checkedGoodsAmount;
    //选中商品总数
    private int checkedGoodsCount;
    //购物车内全部商品总价格
    private BigDecimal goodsAmount;
    //购物车内全部商品总数
    private int goodsCount;

    public CartTotalCount() {
    }

    public CartTotalCount(BigDecimal checkedGoodsAmount, int checkedGoodsCount, BigDecimal goodsAmount, int goodsCount) {
        this.checkedGoodsAmount = checkedGoodsAmount;
        this.checkedGoodsCount = checkedGoodsCount;
        this.goodsAmount = goodsAmount;
        this.goodsCount = goodsCount;
    }

    public BigDecimal getCheckedGoodsAmount() {
        return checkedGoodsAmount;
    }

    public void setCheckedGoodsAmount(BigDecimal checkedGoodsAmount) {
        this.checkedGoodsAmount = checkedGoodsAmount;
    }

    public int getCheckedGoodsCount() {
        return checkedGoodsCount;
    }

    public void setCheckedGoodsCount(int checkedGoodsCount) {
        this.checkedGoodsCount = checkedGoodsCount;
    }

    public BigDecimal getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(BigDecimal goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }
}
