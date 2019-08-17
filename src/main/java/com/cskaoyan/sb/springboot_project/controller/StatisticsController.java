package com.cskaoyan.sb.springboot_project.controller;

import com.cskaoyan.sb.springboot_project.bean.Goods_statistics;
import com.cskaoyan.sb.springboot_project.bean.Order_statistics;
import com.cskaoyan.sb.springboot_project.bean.User_statistics;
import com.cskaoyan.sb.springboot_project.service.GoodsService;
import com.cskaoyan.sb.springboot_project.service.OrderService;
import com.cskaoyan.sb.springboot_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class StatisticsController {
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;
    @Autowired
    GoodsService goodsService;

    //用户统计
    @RequestMapping("/stat/user")
    public Map<String, Object> statistics_user() throws ParseException {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> mapInfo = new HashMap<>();
        List list_columns = new LinkedList();

        //查询前端需要的数据封装在JavaBean的list,再放入map
        List<User_statistics> user_statistics_list = userService.query_user_statistics_bean();
        mapInfo.put("rows", user_statistics_list);

        //封装前端所需的请求
        list_columns.add("day");
        list_columns.add("users");
        mapInfo.put("columns", list_columns);
        map.put("errmsg", "成功");
        map.put("errno", 0);
        map.put("data", mapInfo);
        return map;
    }

    //订单统计
    @RequestMapping("/stat/order")
    public Map<String, Object> statistics_order() {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> mapInfo = new HashMap<>();
        List list_columns = new LinkedList();
        List<Order_statistics> order_statisticsList = orderService.query_order_statistics();
        mapInfo.put("rows", order_statisticsList);
        list_columns.add("day");
        list_columns.add("orders");
        list_columns.add("customers");
        list_columns.add("amount");
        list_columns.add("pcr");
        mapInfo.put("columns", list_columns);
        map.put("errmsg", "成功");
        map.put("errno", 0);
        map.put("data", mapInfo);
        return map;
    }

    //商品统计
    @RequestMapping("/stat/goods")
    public Map<String, Object> statistics_goods() {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> mapInfo = new HashMap<>();
        List list_columns = new LinkedList();
        List<Goods_statistics> goods_statisticsList = goodsService.query_goods_statistics();
        mapInfo.put("rows", goods_statisticsList);
        list_columns.add("day");
        list_columns.add("orders");
        list_columns.add("products");
        list_columns.add("amount");
        mapInfo.put("columns", list_columns);
        map.put("errmsg", "成功");
        map.put("errno", 0);
        map.put("data", mapInfo);
        return map;
    }
}
