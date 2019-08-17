package com.cskaoyan.sb.springboot_project.controller.popluarizeController;


import com.cskaoyan.sb.springboot_project.bean.Coupon;
import com.cskaoyan.sb.springboot_project.bean.Popularize.PopBaseResp;
import com.cskaoyan.sb.springboot_project.bean.Popularize.PopPage;
import com.cskaoyan.sb.springboot_project.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
@RestController
@RequestMapping("admin")
public class CouponController {

    @Autowired
    CouponService couponService;

    /**
     * —— 查询内容、模糊查询 ——
     * 1、判断是否有 name、content，
     *      可以在这里判断，也可以直接在数据库底层 if test判断
     */
    @RequestMapping("coupon/list")
    public PopBaseResp<Map<String, Object>> listCoupon(PopPage popPage,String name,String type,String status) {

/*        System.out.println(popPage);
        System.out.println(name);
        System.out.println(type);
        System.out.println(status);*/

        Map<String, Object> map = couponService.listCoupon(popPage);

        PopBaseResp<Map<String, Object>> couponPopBaseResp = new PopBaseResp<>();
        if (map == null) {
            setErrorInfo(couponPopBaseResp, 1);
        } else {
            couponPopBaseResp.setData(map);
            setErrorInfo(couponPopBaseResp, 0);
        }

        return couponPopBaseResp;
    }


    /**
     * —— 添加 coupon ——
     */
    @RequestMapping("coupon/create")
    public PopBaseResp<Coupon> createCoupon(@RequestBody Coupon coupon,String name) {
        System.out.println(coupon);
        System.out.println(name);

        Coupon coupondedCoupon = couponService.createCoupon(coupon);

        PopBaseResp<Coupon> mapPopBaseResp = new PopBaseResp<>();
        if (coupondedCoupon != null) {
            mapPopBaseResp.setData(coupondedCoupon);
            setErrorInfo(mapPopBaseResp, 0);
        } else {
            mapPopBaseResp.setData(coupondedCoupon);
            setErrorInfo(mapPopBaseResp, 1);
        }

        return mapPopBaseResp;
    }

    /**
     * —— 修改 coupon ——
     */
    @RequestMapping("coupon/update")
    public PopBaseResp<Coupon> updateCoupon(@RequestBody Coupon coupon) {
        Coupon updateCoupon = couponService.updateCoupon(coupon);

        PopBaseResp<Coupon> mapPopBaseResp = new PopBaseResp<>();
        if (updateCoupon != null) {
            mapPopBaseResp.setData(updateCoupon);
            setErrorInfo(mapPopBaseResp, 0);
        } else {
            mapPopBaseResp.setData(updateCoupon);
            setErrorInfo(mapPopBaseResp, 1);
        }

        return mapPopBaseResp;
    }

    /**
     * —— 删除 coupon ——
     */
    @RequestMapping("coupon/delete")
    public PopBaseResp<Coupon> deleteCoupon(@RequestBody  Coupon coupon) {
        Coupon deleteCoupon = couponService.updateCoupon(coupon);
        coupon.setDeleted(true);

        PopBaseResp<Coupon> mapPopBaseResp = new PopBaseResp<>();
        if (deleteCoupon != null) {
            mapPopBaseResp.setData(deleteCoupon);
            setErrorInfo(mapPopBaseResp, 0);
        } else {
            setErrorInfo(mapPopBaseResp, 1);
        }

        return mapPopBaseResp;
    }


    /**
     * —— 添加成功、失败信息 ——
     */
    private void setErrorInfo(PopBaseResp popBaseResp, int isError) {
        if (isError == 0) {
            popBaseResp.setErrmsg("成功");
            popBaseResp.setErrno(0);
        } else {
            popBaseResp.setErrmsg("失败");
            popBaseResp.setErrno(1);
        }
    }
}
