package com.cskaoyan.sb.springboot_project.bean;

import java.util.Arrays;

public class Param {
    Goods goods;
    Goods_product[] products;
    Goods_attribute[] attributes;
    Goods_specification[] specifications;

    public Param() {
    }

    public Param(Goods goods, Goods_product[] products, Goods_attribute[] attributes, Goods_specification[] specifications) {
        this.goods = goods;
        this.products = products;
        this.attributes = attributes;
        this.specifications = specifications;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Goods_product[] getProducts() {
        return products;
    }

    public void setProducts(Goods_product[] products) {
        this.products = products;
    }

    public Goods_attribute[] getAttributes() {
        return attributes;
    }

    public void setAttributes(Goods_attribute[] attributes) {
        this.attributes = attributes;
    }

    public Goods_specification[] getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Goods_specification[] specifications) {
        this.specifications = specifications;
    }

    @Override
    public String toString() {
        return "Param{" +
                "goods=" + goods +
                ", products=" + Arrays.toString(products) +
                ", attributes=" + Arrays.toString(attributes) +
                ", specifications=" + Arrays.toString(specifications) +
                '}';
    }
}
