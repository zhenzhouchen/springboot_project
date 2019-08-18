package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Goods_attribute;

import java.util.List;

public interface Goods_attributeService {
    List<Goods_attribute> queryByGoodsId(Integer goodsId);

    int insert_attributes(Goods_attribute[] attributes);
}
