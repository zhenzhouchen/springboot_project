package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Goods_specification;

import java.util.List;

public interface Goods_specificationMapper {
    int updateByPrimaryKeySelective(Goods_specification record);

    int updateByPrimaryKey(Goods_specification record);

    List<Goods_specification> queryByGoodsId(Integer id);
}