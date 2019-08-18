package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Goods_attribute;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Goods_attributeMapper {
    int updateByPrimaryKeySelective(Goods_attribute record);

    int updateByPrimaryKey(Goods_attribute record);

    List<Goods_attribute> queryByGoodsId(Integer goodsId);

    int insert_attributes(@Param("attributes") Goods_attribute[] attributes);
}