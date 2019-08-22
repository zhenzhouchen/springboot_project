package com.cskaoyan.sb.springboot_project.controller.popluarizeController;


import com.cskaoyan.sb.springboot_project.bean.Coupon;
import com.cskaoyan.sb.springboot_project.bean.Popularize.BaseResp;
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
    public BaseResp<Map<String, Object>> listCoupon(PopPage popPage, String name, String type, String status) {


        Map<String, Object> couponResult = null;
        if (name != null || type != null) {
            couponResult = couponService.searchCoupon(popPage, name, type,status);
        } else {
            couponResult = couponService.listCoupon(popPage);
        }

        BaseResp<Map<String, Object>> couponPopBaseResp = new BaseResp<>();
        if (couponResult == null) {
            setErrorInfo(couponPopBaseResp, 1);
        } else {
            couponPopBaseResp.setData(couponResult);
            setErrorInfo(couponPopBaseResp, 0);
        }

        return couponPopBaseResp;
    }


    /**
     * —— 添加 coupon ——
     */
    @RequestMapping("coupon/create")
    public BaseResp<Coupon> createCoupon(@RequestBody Coupon coupon) {

        Coupon coupondedCoupon = couponService.createCoupon(coupon);

        BaseResp<Coupon> mapPopBaseResp = new BaseResp<>();
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
    public BaseResp<Coupon> updateCoupon(@RequestBody Coupon coupon) {
        Coupon updateCoupon = couponService.updateCoupon(coupon);

        BaseResp<Coupon> mapPopBaseResp = new BaseResp<>();
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
    public BaseResp<Coupon> deleteCoupon(@RequestBody Coupon coupon) {
        coupon.setDeleted(true);
        Coupon deleteCoupon = couponService.updateCoupon(coupon);

        BaseResp<Coupon> mapPopBaseResp = new BaseResp<>();
        if (deleteCoupon != null) {
            setErrorInfo(mapPopBaseResp, 0);
        } else {
            setErrorInfo(mapPopBaseResp, 1);
        }
         /*   Map<String, Object> map = new HashMap<>();
        if (deleteCoupon != null) {
            map.put("errmsg", "成功");
            map.put("errno", 0);

        }*/

        return mapPopBaseResp;
    }

    /**
     * —— 显示详情 ——
     */
    @RequestMapping("coupon/read")
    public BaseResp<Coupon> readCoupon(@RequestBody String id) {
        Coupon readCoupon = couponService.readCouponById(id);
        BaseResp<Coupon> mapPopBaseResp = new BaseResp<>();
        if (readCoupon != null) {
            mapPopBaseResp.setData(readCoupon);
            setErrorInfo(mapPopBaseResp, 0);
        } else {
            setErrorInfo(mapPopBaseResp, 1);
        }

        return mapPopBaseResp;
    }

    /**
     * —— 根据 couponId 获得有该优惠券的 用户 ——
     * TODO: listuser： 查询用户
     *  由于没有数据，不好抓包，可能要用到多表查询
     */
    @RequestMapping("coupon/listuser?page=1&limit=20&couponId=54&sort=add_time&order=desc")
    public BaseResp<Map<String,Object>> listUserByCoupon(PopPage popPage, String couponId) {

        Map<String,Object> userResult = couponService.listUserById(popPage, couponId);

        BaseResp<Map<String,Object>> mapPopBaseResp = new BaseResp<>();
        if (userResult != null) {
            mapPopBaseResp.setData(userResult);
            setErrorInfo(mapPopBaseResp, 0);
        } else {
            setErrorInfo(mapPopBaseResp, 1);
        }

        return mapPopBaseResp;

    }

    /**
     * —— 添加成功、失败信息 ——
     */
    private void setErrorInfo(BaseResp popBaseResp, int isError) {
        if (isError == 0) {
            popBaseResp.setErrmsg("成功");
            popBaseResp.setErrno(0);
        } else {
            popBaseResp.setErrmsg("失败");
            popBaseResp.setErrno(1);
        }
    }
}
