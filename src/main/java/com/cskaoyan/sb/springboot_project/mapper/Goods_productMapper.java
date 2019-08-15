package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Goods_product;

public interface Goods_productMapper {
    int updateByPrimaryKeySelective(Goods_product record);

    int updateByPrimaryKey(Goods_product record);
}