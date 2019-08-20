package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Goods;
import com.cskaoyan.sb.springboot_project.bean.Goods_product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Goods_productMapper {
    int updateByPrimaryKeySelective(Goods_product record);

    int updateByPrimaryKey(Goods_product record);

    List<Goods_product> queryByGoodsId(Integer id);

    int insertProduct(@Param("products") List<Goods_product> products);

    int deleteProduct(@Param("goods") Goods goods);
}