package com.cskaoyan.sb.springboot_project.service;

import java.util.Map;

public interface OrderService {
    Map<String, Object> selectOrderList(int page, int limit, Integer[] orderStatusArray, String add_time, String order, Integer userId, String orderSn);

    Map<String, Object> selectOrderDetailById(int id);
}
