package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Coupon;

public interface CouponMapper {
    int updateByPrimaryKeySelective(Coupon record);

    int updateByPrimaryKey(Coupon record);
}