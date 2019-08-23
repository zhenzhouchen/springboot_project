package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Cart;
import com.cskaoyan.sb.springboot_project.bean.CartChecked;
import com.cskaoyan.sb.springboot_project.bean.ResponseVo;

import java.util.Date;
import java.util.Map;

public interface CartWxService {
    Map<String, Object> selectCartListByUserId(int userId);

    int addIntoCart(Cart cart, int userId);

    int checkGoods(CartChecked cartChecked, int userId);

    int deleteCartGoodsByProductIds(CartChecked cartChecked, Date updateTime, int userId);

    int selectGoodsCount(Integer userId);

    int updateCartGoods(Cart cart);

    ResponseVo goodsCount(Integer userId);
}
