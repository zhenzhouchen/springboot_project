package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Goods_attribute;

public interface Goods_attributeMapper {
    int updateByPrimaryKeySelective(Goods_attribute record);

    int updateByPrimaryKey(Goods_attribute record);
}