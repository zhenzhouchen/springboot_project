package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Order_statistics;

import java.util.List;
import java.util.Map;

public interface OrderService {
    Map<String, Object> selectOrderList(int page, int limit, Integer[] orderStatusArray, String sort, String order, Integer userId, String orderSn);

    Map<String, Object> selectOrderDetailById(int id);

    List<Order_statistics> query_order_statistics();
}
