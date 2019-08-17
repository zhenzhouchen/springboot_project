package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Goods_product;

import java.util.List;

public interface Goods_productMapper {
    int updateByPrimaryKeySelective(Goods_product record);

    int updateByPrimaryKey(Goods_product record);

    List<Goods_product> queryByGoodsId(Integer id);
}