package com.cskaoyan.sb.springboot_project.bean;

public class Order_config {
    String cskaoyan_mall_order_comment;
    String cskaoyan_mall_order_unconfirm;
    String cskaoyan_mall_order_unpaid;

    public Order_config() {
    }

    public Order_config(String cskaoyan_mall_order_comment, String cskaoyan_mall_order_unconfirm, String cskaoyan_mall_order_unpaid) {
        this.cskaoyan_mall_order_comment = cskaoyan_mall_order_comment;
        this.cskaoyan_mall_order_unconfirm = cskaoyan_mall_order_unconfirm;
        this.cskaoyan_mall_order_unpaid = cskaoyan_mall_order_unpaid;
    }

    public String getCskaoyan_mall_order_comment() {
        return cskaoyan_mall_order_comment;
    }

    public void setCskaoyan_mall_order_comment(String cskaoyan_mall_order_comment) {
        this.cskaoyan_mall_order_comment = cskaoyan_mall_order_comment;
    }

    public String getCskaoyan_mall_order_unconfirm() {
        return cskaoyan_mall_order_unconfirm;
    }

    public void setCskaoyan_mall_order_unconfirm(String cskaoyan_mall_order_unconfirm) {
        this.cskaoyan_mall_order_unconfirm = cskaoyan_mall_order_unconfirm;
    }

    public String getCskaoyan_mall_order_unpaid() {
        return cskaoyan_mall_order_unpaid;
    }

    public void setCskaoyan_mall_order_unpaid(String cskaoyan_mall_order_unpaid) {
        this.cskaoyan_mall_order_unpaid = cskaoyan_mall_order_unpaid;
    }

    @Override
    public String toString() {
        return "Order_config{" +
                "cskaoyan_mall_order_comment='" + cskaoyan_mall_order_comment + '\'' +
                ", cskaoyan_mall_order_unconfirm='" + cskaoyan_mall_order_unconfirm + '\'' +
                ", cskaoyan_mall_order_unpaid='" + cskaoyan_mall_order_unpaid + '\'' +
                '}';
    }
}
