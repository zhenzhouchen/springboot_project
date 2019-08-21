package com.cskaoyan.sb.springboot_project.controller.wxcontroller;


import com.cskaoyan.sb.springboot_project.bean.Cart;
import com.cskaoyan.sb.springboot_project.bean.CartChecked;
import com.cskaoyan.sb.springboot_project.service.CartWxService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("wx/cart")
@RestController
public class CartWxController {

    @Autowired
    CartWxService cartWxService;

    @RequestMapping("index")
    @ApiOperation("cartIndex")
    public Map<String, Object> cartIndex() {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        Map<String, Object> cartDataMap = cartWxService.selectCartListByUsername(username);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("data", cartDataMap);
        hashMap.put("errmsg", "成功");
        hashMap.put("errno", 0);
        return hashMap;
    }

    @RequestMapping("add")
    @ApiOperation("addIntoCart")
    public Map<String, Object> addIntoCart(@RequestBody Cart cart) {
        int i = cartWxService.addIntoCart(cart);
        HashMap<String, Object> hashMap = new HashMap<>();
        if(i >= 1) {

            hashMap.put("errmsg", "成功");
            hashMap.put("errno", 0);
        }
        return hashMap;
    }

    @RequestMapping("checked")
    @ApiOperation("checkGood")
    public Map<String, Object> checkGoods(@RequestBody CartChecked cartChecked) {
        Map<String, Object> cartDataMap = cartWxService.checkGoods(cartChecked);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("data", cartDataMap);
        hashMap.put("errmsg", "成功");
        hashMap.put("errno", 0);
        return hashMap;
    }

    @RequestMapping("delete")
    @ApiOperation("deleteCartGoods")
    public Map<String, Object> deleteCartGoods(@RequestBody CartChecked cartChecked) {
        Map<String, Object> cartDataMap = cartWxService.deleteCartGoodsByProductIds(cartChecked);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("data", cartDataMap);
        hashMap.put("errmsg", "成功");
        hashMap.put("errno", 0);
        return hashMap;
    }
}
