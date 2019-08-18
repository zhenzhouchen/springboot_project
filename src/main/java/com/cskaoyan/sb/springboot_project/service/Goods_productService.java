package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Goods_product;

import java.util.List;

public interface Goods_productService {
    List<Goods_product> queryByGoodsId(Integer id);

    int insert_products(Goods_product[] products);
}
