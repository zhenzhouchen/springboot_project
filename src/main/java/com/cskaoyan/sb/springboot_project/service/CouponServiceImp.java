package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Ad;
import com.cskaoyan.sb.springboot_project.bean.Coupon;
import com.cskaoyan.sb.springboot_project.bean.Popularize.PopPage;
import com.cskaoyan.sb.springboot_project.mapper.AdMapper;
import com.cskaoyan.sb.springboot_project.mapper.CouponMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CouponServiceImp implements CouponService {

    @Autowired
    CouponMapper couponMapper;

    /**
     * —— 查询所有 coupon ——
     * 1、传入分页参数
     * 2、利用 mapper 进行查询
     */
    @Override
    public Map<String,Object> listCoupon(PopPage popPage) {

        PageHelper.startPage(popPage.getPage(), popPage.getLimit());
        List<Coupon> coupons = couponMapper.listCouponByCondition(popPage.getSort(),popPage.getOrder());

        PageInfo<Coupon> pageInfo = new PageInfo<>(coupons);
        long total = pageInfo.getTotal();

        Map<String, Object> data = new HashMap<>();
        data.put("items", coupons);
        data.put("total",total);



        return data;
    }

    @Override
    public Coupon createCoupon(Coupon coupon) {

        Date date = new Date();
        coupon.setAddTime(date);
        coupon.setUpdateTime(date);
        coupon.setDeleted(false);

        int insert = couponMapper.insert(coupon);

        if (insert > 0) {
            return coupon;
        } else
            return null;
    }

    @Override
    public Coupon updateCoupon(Coupon coupon) {
        Date date = new Date();
        coupon.setUpdateTime(date);

        int update = couponMapper.updateByPrimaryKey(coupon);
        if (update > 0) {
            return coupon;
        } else
            return null;
    }
}
