package com.cskaoyan.sb.springboot_project.controller.wxcontroller;


import com.cskaoyan.sb.springboot_project.bean.Cart;
import com.cskaoyan.sb.springboot_project.bean.CartChecked;
import com.cskaoyan.sb.springboot_project.service.CartWxService;
import com.cskaoyan.sb.springboot_project.util.UserTokenManager;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("wx/cart")
@RestController
public class CartWxController {

    @Autowired
    CartWxService cartWxService;

    @RequestMapping("index")
    @ApiOperation("cartIndex")
    public Map<String, Object> cartIndex(HttpServletRequest request) {
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        Map<String, Object> cartDataMap = cartWxService.selectCartListByUserId(userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("data", cartDataMap);
        hashMap.put("errmsg", "成功");
        hashMap.put("errno", 0);
        return hashMap;
    }

    @RequestMapping("add")
    @ApiOperation("addIntoCart")
    public Map<String, Object> addIntoCart(@RequestBody Cart cart, HttpServletRequest request) {
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        int result = cartWxService.addIntoCart(cart, userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        if(result == 711) {
            hashMap.put("data", "");
            hashMap.put("errmsg", "成功");
            hashMap.put("errno", 711);
        } else if (result == 808) {
            int total = cartWxService.selectGoodsCount(userId);
            hashMap.put("data", total);
            hashMap.put("errmsg", "成功");
            hashMap.put("errno", 808);
        }
        return hashMap;
    }

    @RequestMapping("checked")
    @ApiOperation("checkGood")
    public Map<String, Object> checkGoods(@RequestBody CartChecked cartChecked, HttpServletRequest request) {
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        if(userId == null) {
            return null;
        }
        int result = cartWxService.checkGoods(cartChecked, userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        if(result > 0) {//更新checked成功
            Map<String, Object> cartDataMap = cartWxService.selectCartListByUserId(userId);
            hashMap.put("data", cartDataMap);
            hashMap.put("errmsg", "成功");
            hashMap.put("errno", 0);
        }
        return hashMap;
    }

    @RequestMapping("delete")
    @ApiOperation("deleteCartGoods")
    public Map<String, Object> deleteCartGoods(@RequestBody CartChecked cartChecked, HttpServletRequest request) {
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        int result = cartWxService.deleteCartGoodsByProductIds(cartChecked, new Date(), userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        if(result > 0) {
            Map<String, Object> cartDataMap = cartWxService.selectCartListByUserId(userId);
            hashMap.put("data", cartDataMap);
            hashMap.put("errno", 0);
            hashMap.put("errmsg", "成功");
        }

        return hashMap;
    }

    @RequestMapping("update")
    @ApiOperation("updateCartGoods")
    public Map<String, Object> updateCartGoods(@RequestBody Cart cart, HttpServletRequest request) {
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        cart.setUserId(userId);
        cart.setUpdateTime(new Date());
        int result = cartWxService.updateCartGoods(cart);
        HashMap<String, Object> hashMap = new HashMap<>();
        if(result > 0) {
            hashMap.put("errmsg", "成功");
            hashMap.put("errno", 0);
        }
        return hashMap;
    }
}
