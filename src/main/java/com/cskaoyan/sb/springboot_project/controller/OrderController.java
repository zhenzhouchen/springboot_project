package com.cskaoyan.sb.springboot_project.controller;

import com.cskaoyan.sb.springboot_project.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/list")
    @ApiOperation("获取order列表")
    public Map<String, Object> selectOrderList(int page, int limit, Integer[] orderStatusArray, String sort, String order, Integer userId, String orderSn) {
        Map<String, Object> orderMap = orderService.selectOrderList(page, limit, orderStatusArray, sort, order, userId, orderSn);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("data", orderMap);
        hashMap.put("errno", 0);
        hashMap.put("errmsg", "成功");
        return hashMap;
    }

    @RequestMapping("/detail")
    @ApiOperation("detail详情")
    public Map<String, Object> selectOrderDetailById(int id) {
        Map<String, Object> detailMap = orderService.selectOrderDetailById(id);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("data", detailMap);
        hashMap.put("errmsg", "成功");
        hashMap.put("errno", 0);
        return hashMap;
    }
}
