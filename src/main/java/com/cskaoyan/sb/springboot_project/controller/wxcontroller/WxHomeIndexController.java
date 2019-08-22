package com.cskaoyan.sb.springboot_project.controller.wxcontroller;

import com.cskaoyan.sb.springboot_project.bean.Goods;
import com.cskaoyan.sb.springboot_project.service.WxHomeIndexService;
import com.cskaoyan.sb.springboot_project.util.UserTokenManager;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wx")
public class WxHomeIndexController {
    @Autowired
    WxHomeIndexService wxIndexService;

    @RequestMapping("/home/index")
    public Map<String, Object> homeIndex() {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> data = wxIndexService.queryAllIndexList();
        map.put("data", data);
        map.put("errmsg", "成功");
        map.put("errno", 0);
        return map;
    }

    @RequestMapping("/goods/count")
    public Map<String, Object> goodsCount() {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        List<Integer> goodsCount = wxIndexService.goodsCount();
        data.put("goodsCount", goodsCount);
        map.put("data", data);
        map.put("errmsg", "成功");
        map.put("errno", 0);
        return map;
    }

    @RequestMapping("/search/index")
    public Map<String, Object> searchGoods() {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> data = wxIndexService.searchGoods();
        map.put("data", data);
        map.put("errmsg", "成功");
        map.put("errno", 0);
        return map;
    }

    @RequestMapping("/goods/list")
    public Map<String, Object> searchGoodslist(String keyword) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> data = wxIndexService.searchGoodslist(keyword);
        map.put("data", data);
        map.put("errmsg", "成功");
        map.put("errno", 0);
        return map;
    }

    @RequestMapping("/coupon/receive")
    public Map<String, Object> couponReceive(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        if (userId != null) {
//            int i = wxIndexService.queryCouponReceive();
//            if (i>0){
            map.put("errmsg", "优惠券已经领取过");
            map.put("errno", 740);
//            }else {
//                int j = wxIndexService.addCoupon();
//                map.put("errmsg", "成功");
//                map.put("errno", 0);
//            }
        }
        return map;
    }

}
