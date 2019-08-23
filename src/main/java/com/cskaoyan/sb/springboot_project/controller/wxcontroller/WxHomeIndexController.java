package com.cskaoyan.sb.springboot_project.controller.wxcontroller;

import com.cskaoyan.sb.springboot_project.bean.Category;
import com.cskaoyan.sb.springboot_project.bean.Goods;
import com.cskaoyan.sb.springboot_project.service.CategoryService;
import com.cskaoyan.sb.springboot_project.service.GoodsService;
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

    @Autowired
    GoodsService goodsService;

    @Autowired
    CategoryService categoryService;

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

    @RequestMapping("/search/clearhistory")
    public Map<String, Object> clearHistory(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        if (userId != null){
            int i = wxIndexService.clearHistory(userId);
            if (i > 0) {
                map.put("errmsg", "成功");
                map.put("errno", 0);
            }
        }
        return map;
    }

    @RequestMapping("/search/helper")
    public Map<String, Object> searchHelper(String keyword) {
        Map<String, Object> map = new HashMap<>();
        List<String> data = wxIndexService.searchHelper(keyword);
        map.put("data", data);
        map.put("errmsg", "成功");
        map.put("errno", 0);
        return map;
    }

    @RequestMapping("/goods/list")
    public Map<String, Object> searchGoodslist(HttpServletRequest request, String keyword,int categoryId,int page,int size) {
        Map<String, Object> map = new HashMap<>();
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        if (userId != null) {
            wxIndexService.updateSearchHistory(userId, keyword);
        }

        // 搜索和显示集合 ： 有 keywords 则搜索
        Map<String, Object> data = null;
        if (keyword != null) {
            data = wxIndexService.searchGoodslist(keyword);
            List<Category> filterCategoryList = categoryService.getFilterList(20);
            data.put("filterCategoryList", filterCategoryList);
        } else {
            data = goodsService.queryGoodsById(categoryId, page, size);
        }
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

    @RequestMapping("/coupon/mylist")
    public Map<String, Object> couponMyList(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        if (userId != null) {
            Map<String, Object> data = wxIndexService.couponMyList();
            map.put("data", data);
            map.put("errmsg", "成功");
            map.put("errno", 0);
        }
        return map;
    }

}
