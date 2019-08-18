package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Goods_specification;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Goods_specificationMapper {
    int updateByPrimaryKeySelective(Goods_specification record);

    int updateByPrimaryKey(Goods_specification record);

    List<Goods_specification> queryByGoodsId(Integer id);

    int insert_specification(@Param("specifications") Goods_specification[] specifications);
}