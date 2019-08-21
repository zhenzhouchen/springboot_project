package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Cart;
import com.cskaoyan.sb.springboot_project.bean.CartChecked;
import com.cskaoyan.sb.springboot_project.bean.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

public interface CartMapper {
    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    List<Cart> selectCartListByUserId(@Param("userId") int userId);
    @Select("select id from cskaoyan_mall_cart where product_id = #{productId} and user_id = #{userId}")
    Goods selectRecordByProductId(@Param("productId") Integer productId, @Param("userId") int userId);

    int updateCart(@Param("cart") Cart cart);

    int addIntoCart(@Param("cart") Cart cart);

    int checkGoods(@Param("checked") int checked, @Param("productId") int productId, @Param("updateTime") Date updateTime, @Param("userId") int userId);

    int updateCartGoods(@Param("cart") Cart cart);

    @Update("update cskaoyan_mall_cart set deleted = 1, update_time = #{updateTime} where user_id = #{userId} and product_id = #{productId}")
    int deleteCartGoodsByProductIds(@Param("productId") int productId, @Param("updateTime") Date updateTime, @Param("userId") int userId);
}