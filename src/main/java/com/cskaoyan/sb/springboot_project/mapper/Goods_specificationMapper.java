package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Goods_specification;

public interface Goods_specificationMapper {
    int updateByPrimaryKeySelective(Goods_specification record);

    int updateByPrimaryKey(Goods_specification record);
}