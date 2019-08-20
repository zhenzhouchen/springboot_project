package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Goods;
import com.cskaoyan.sb.springboot_project.bean.Goods_attribute;
import com.cskaoyan.sb.springboot_project.bean.Goods_create;

import java.util.List;

public interface Goods_attributeService {
    List<Goods_attribute> queryByGoodsId(Integer goodsId);

    int insertAttribute(List<Goods_attribute> attributes, Goods goods);

    void updateAttribute(Goods_create update);
}
