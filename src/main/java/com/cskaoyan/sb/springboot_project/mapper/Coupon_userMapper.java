package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Coupon_user;

public interface Coupon_userMapper {
    int updateByPrimaryKeySelective(Coupon_user record);

    int updateByPrimaryKey(Coupon_user record);
}