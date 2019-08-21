package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Cart;
import com.cskaoyan.sb.springboot_project.bean.Goods;
import com.cskaoyan.sb.springboot_project.bean.Goods_product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

public interface Goods_productMapper {
    int updateByPrimaryKeySelective(Goods_product record);

    int updateByPrimaryKey(Goods_product record);

    List<Goods_product> queryByGoodsId(Integer id);

    int insertProduct(@Param("products") List<Goods_product> products);

    int deleteProduct(@Param("goods") Goods goods);
    @Select("select number from cskaoyan_mall_goods_product where goods_id = #{goodsId}")
    int selectInventoryByGoodsId(Integer goodsId);

    int updateInventory(@Param("cart") Cart cart, @Param("updateTime") Date date);

    Goods_product selectProductByProductId(@Param("productId") Integer productId);
}