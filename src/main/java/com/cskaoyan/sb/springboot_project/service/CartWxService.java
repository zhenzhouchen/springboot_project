package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Cart;
import com.cskaoyan.sb.springboot_project.bean.CartChecked;

import java.util.Map;

public interface CartWxService {
    Map<String, Object> selectCartListByUsername(String username);

    int addIntoCart(Cart cart);

    Map<String, Object> checkGoods(CartChecked cartChecked);

    Map<String, Object> deleteCartGoodsByProductIds(CartChecked cartChecked);
}
