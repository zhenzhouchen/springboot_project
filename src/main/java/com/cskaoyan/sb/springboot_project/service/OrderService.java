package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.OrderInfo_wx;
import com.cskaoyan.sb.springboot_project.bean.Order_statistics;

import java.util.List;
import java.util.Map;

public interface OrderService {
    Map<String, Object> selectOrderList(int page, int limit, Integer[] orderStatusArray, String sort, String order, Integer userId, String orderSn);

    Map<String, Object> selectOrderDetailById(int id);

    List<Order_statistics> query_order_statistics();

    List<OrderInfo_wx> queryOrderInfoById(Integer userId);

    List<OrderInfo_wx> queryOrderInfoByIdNoPaied(Integer userId);

    List<OrderInfo_wx> queryOrderInfoByIdNoShip(Integer userId);

    List<OrderInfo_wx> queryOrderInfoByIdNoReceive(Integer userId);

    List<OrderInfo_wx> queryOrderInfoByIdNoComment(Integer userId);
}
