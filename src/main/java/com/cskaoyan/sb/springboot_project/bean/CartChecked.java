package com.cskaoyan.sb.springboot_project.bean;
//购物车选中商品信息
public class CartChecked {
    private int isChecked;

    private int[] productIds;

    public int getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(int isChecked) {
        this.isChecked = isChecked;
    }

    public int[] getProductIds() {
        return productIds;
    }

    public void setProductIds(int[] productIds) {
        this.productIds = productIds;
    }
}
