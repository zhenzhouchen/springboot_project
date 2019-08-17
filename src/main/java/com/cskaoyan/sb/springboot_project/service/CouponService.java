package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Coupon;
import com.cskaoyan.sb.springboot_project.bean.Popularize.PopPage;

import java.util.Map;

public interface CouponService {
    Map<String, Object> listCoupon(PopPage popPage);

    Coupon createCoupon(Coupon coupon);

    Coupon updateCoupon(Coupon coupon);
}
