package com.cskaoyan.sb.springboot_project.bean;

import java.util.List;

public class Goods_create {

    private Goods goods;

    private List<Goods_attribute> attributes;

    private List<Goods_product> products;

    private List<Goods_specification> specifications;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public List<Goods_attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Goods_attribute> attributes) {
        this.attributes = attributes;
    }

    public List<Goods_product> getProducts() {
        return products;
    }

    public void setProducts(List<Goods_product> products) {
        this.products = products;
    }

    public List<Goods_specification> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<Goods_specification> specifications) {
        this.specifications = specifications;
    }
}
