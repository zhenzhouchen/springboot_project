package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Coupon_user;
import org.apache.ibatis.annotations.Select;

public interface Coupon_userMapper {
    int updateByPrimaryKeySelective(Coupon_user record);

    int updateByPrimaryKey(Coupon_user record);
    @Select("select count(id) from cskaoyan_mall_coupon_user where user_id = #{userId} and status = 1")
    int queryCouponCount(Integer userId);
}