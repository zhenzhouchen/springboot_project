package com.cskaoyan.sb.springboot_project.service;


import com.cskaoyan.sb.springboot_project.bean.*;
import com.cskaoyan.sb.springboot_project.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.System;
import java.math.BigDecimal;
import java.util.*;

@Service
public class CartWxServiceImpl implements CartWxService {

    @Autowired
    CartMapper cartMapper;
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    Goods_productMapper goods_productMapper;
    @Autowired
    CouponMapper couponMapper;
    @Autowired
    Coupon_userMapper coupon_userMapper;
    @Autowired
    AddressMapper addressMapper;

    @Override
    public Map<String, Object> selectCartListByUserId(int userId) {
        List<Cart> cartList = cartMapper.selectCartListByUserId(userId);
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
    @Transactional//事务
    public int addIntoCart(Cart cart, int userId) {
        //查询商品库存
        try {
            int inventory = goods_productMapper.selectInventoryByGoodsId(cart.getGoodsId());
            if(inventory - cart.getNumber() < 0) {//库存不足
                return 711;
            }
            //更新库存
            /*int i = goods_productMapper.updateInventory(cart, new Date());
            if(i <= 0) {
                throw new Exception("更新库存失败");
            }*/
            //查询购物车是否已经有该商品
            Goods record = cartMapper.selectRecordByProductId(cart.getProductId(), userId);
            //更新购物车结果
            int flag = 0;
            if(record != null) {//商品已经存在，更新商品数量和UpdateTime
                cart.setUpdateTime(new Date());
                cart.setUserId(userId);
                flag = cartMapper.updateCart(cart);
            } else {//新加入商品
                Goods goods = goodsMapper.selectGoodByGoodsId(cart.getGoodsId());
                Goods_product goods_product = goods_productMapper.selectProductByProductId(cart.getProductId());
                cart.setUserId(userId);
                cart.setGoodsSn(goods.getGoodsSn());
                cart.setGoodsName(goods.getName());
                cart.setPrice(goods_product.getPrice());
                cart.setSpecifications(goods_product.getSpecifications());
                cart.setChecked(true);
                cart.setPicUrl(goods_product.getUrl());
                Date date = new Date();
                cart.setAddTime(date);
                cart.setUpdateTime(date);
                cart.setDeleted(false);
                flag = cartMapper.addIntoCart(cart);
            }
            //更新购物车成功
            if(flag >= 1) {
                return 808;
            } else {
                throw new Exception("更新购物车数据失败");
            }
        } catch (Exception e) {
            return 0;//添加购物车失败
        }
    }

    @Override
    public int checkGoods(CartChecked cartChecked, int userId) {
        int flag = 0;
        Date date = new Date();
        for (int productId : cartChecked.getProductIds()) {
            flag = cartMapper.checkGoods(cartChecked.getIsChecked(), productId, date, userId);
        }
        return flag;
    }

    @Override
    public int deleteCartGoodsByProductIds(CartChecked cartChecked, Date updateTime, int userId) {
        int result = 0;
        for (int productId : cartChecked.getProductIds()) {
            result = cartMapper.deleteCartGoodsByProductIds(productId, updateTime, userId);
        }
        return result;
    }


    @Override
    public int selectGoodsCount(Integer userId) {
        List<Cart> cartList = cartMapper.selectCartListByUserId(userId);
        int total = 0;
        for (Cart cart : cartList) {
            total = total + cart.getNumber();
        }
        return total;
    }

    @Override
    public int updateCartGoods(Cart cart) {
        return cartMapper.updateCartGoods(cart);
    }

    @Override
    public ResponseVo goodsCount(Integer userId) {
        List<Cart> cartList = cartMapper.selectCartListByUserId(userId);
        int count = 0;
        for (Cart cart : cartList) {
            count += cart.getNumber();
        }
        return new ResponseVo(count, "成功", 0);
    }

    @Override
    @Transactional
    public ResponseVo checkoutOrder(Integer userId, int cartId, int addressId, int couponId, int grouponRulesId) {
        try {
            //获取下单商品清单
            List<Cart> cartList = cartMapper.selectCartCheckedListByUserId(userId);
            BigDecimal goodsTotalPrice = BigDecimal.valueOf(0);
            BigDecimal actualPrice = BigDecimal.valueOf(0);
            BigDecimal orderTotalPrice = BigDecimal.valueOf(0);
            BigDecimal couponPrice = BigDecimal.valueOf(0);
            BigDecimal freightPrice = BigDecimal.valueOf(0);//邮费设为0
            BigDecimal grouponPrice = BigDecimal.valueOf(0);//拼团设为0
            for (Cart cart : cartList) {
                /*//清单商品从购物车删除
                cartMapper.deleteCartGoodsByProductIds(cart.getProductId(), new Date(), userId);*/
                /*//清单商品减少库存
                goods_productMapper.updateInventory(cart, new Date(), cart.getNumber());*/
                //计算清单商品总价格
                goodsTotalPrice = goodsTotalPrice.add(cart.getPrice().multiply(new BigDecimal(cart.getNumber())));
            }
            //查询可用的优惠券数量
            int couponCount = coupon_userMapper.queryCouponCount(userId);
            //查询优惠券折扣
            if(couponId > 0) {
                CouponExample couponExample = new CouponExample();
                couponExample.createCriteria().andIdEqualTo(couponId);
                List<Coupon> coupons = couponMapper.selectByExample(couponExample);
                Coupon coupon = coupons.get(0);
                couponPrice = coupon.getDiscount();
            }
            actualPrice = goodsTotalPrice.subtract(couponPrice);
            orderTotalPrice = goodsTotalPrice.add(freightPrice).subtract(couponPrice);
            Address checkedAddress = null;
            if(addressId == 0) {
                checkedAddress = addressMapper.queryDefaultAddress(userId);
            } else {
                checkedAddress = addressMapper.queryAddressReceByAddressId(addressId);
            }
            //返回参数
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("actualPrice", actualPrice);
            hashMap.put("addressId", addressId);
            hashMap.put("availableCouponLength", couponCount);
            hashMap.put("checkedAddress", checkedAddress);
            hashMap.put("checkedGoodsList", cartList);
            hashMap.put("couponId", couponId);
            hashMap.put("couponPrice", couponPrice);
            hashMap.put("freightPrice", freightPrice);
            hashMap.put("goodsTotalPrice", goodsTotalPrice);
            hashMap.put("grouponPrice", grouponPrice);
            hashMap.put("grouponRulesId", grouponRulesId);
            hashMap.put("orderTotalPrice", orderTotalPrice);
            return new ResponseVo(hashMap, "成功", 0);
        } catch (Exception e) {
            e.getStackTrace();
            return new ResponseVo("失败", -1);
        }
    }
}
