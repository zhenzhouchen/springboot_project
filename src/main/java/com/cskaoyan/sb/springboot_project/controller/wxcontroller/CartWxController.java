package com.cskaoyan.sb.springboot_project.controller.wxcontroller;


import com.cskaoyan.sb.springboot_project.service.CartWxService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
}
