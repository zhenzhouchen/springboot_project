package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Cart;
import com.cskaoyan.sb.springboot_project.bean.CartChecked;
import com.cskaoyan.sb.springboot_project.bean.CartTotalCount;
import com.cskaoyan.sb.springboot_project.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartWxServiceImpl implements CartWxService {

    @Autowired
    CartMapper cartMapper;

    @Override
    public Map<String, Object> selectCartListByUsername(String username) {
        List<Cart> cartList = cartMapper.selectCartListByUsername(username);
        BigDecimal checkedGoodsAmount = BigDecimal.valueOf(0);
        int checkedGoodsCount = 0;
        BigDecimal goodsAmount = BigDecimal.valueOf(0);
        int goodsCount = 0;
        for (Cart good : cartList) {
            if(good.getChecked()) {
                checkedGoodsCount += good.getNumber();
                checkedGoodsAmount = checkedGoodsAmount.add(good.getPrice().multiply(new BigDecimal(good.getNumber())));
            }
            goodsCount += good.getNumber();
            goodsAmount = goodsAmount.add(good.getPrice().multiply(new BigDecimal(good.getNumber())));
        }
        CartTotalCount cartTotal = new CartTotalCount(checkedGoodsAmount, checkedGoodsCount, goodsAmount, goodsCount);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("cartList", cartList);
        hashMap.put("cartTotal", cartTotal);
        return hashMap;
    }

    @Override
    public int addIntoCart(Cart cart) {
        return 0;
    }

    @Override
    public Map<String, Object> checkGoods(CartChecked cartChecked) {
        return null;
    }

    @Override
    public Map<String, Object> deleteCartGoodsByProductIds(CartChecked cartChecked) {
        return null;
    }
}
