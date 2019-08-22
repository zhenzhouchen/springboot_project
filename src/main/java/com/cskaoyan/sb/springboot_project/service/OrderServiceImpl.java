package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.*;
import com.cskaoyan.sb.springboot_project.mapper.OrderMapper;
import com.cskaoyan.sb.springboot_project.mapper.Order_goodsMapper;
import com.cskaoyan.sb.springboot_project.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    Order_goodsMapper order_goodsMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public Map<String, Object> selectOrderList(int page, int limit, Integer[] orderStatusArray, String sort, String order, Integer userId, String orderSn) {
        PageHelper.startPage(page, limit);
        List<Order> orderList = orderMapper.selectOrderList(page, limit, orderStatusArray, sort, order, userId, orderSn);
        PageInfo<Order> orderPageInfo = new PageInfo<>(orderList);
        long total = orderPageInfo.getTotal();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("items", orderList);
        hashMap.put("total", total);
        return hashMap;
    }

    @Override
    public Map<String, Object> selectOrderDetailById(int id) {
        Order order = orderMapper.selectOrderDetailByOrderId(id);
        List<Order_goods> order_goodsList = order_goodsMapper.selectOrderGoodsListByOrderId(id);
        User user = userMapper.selectUserDetailForOrderByUserId(order.getUserId());
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("order", order);
        hashMap.put("orderGoods", order_goodsList);
        hashMap.put("user", user);
        return hashMap;
    }

    @Override
    public List<Order_statistics> query_order_statistics() {
        return orderMapper.query_order_statistics();
    }

    @Override
    public List<OrderInfo_wx> queryOrderInfoById(Integer userId) {
        return orderMapper.queryOrderInfoById(userId);
    }

    @Override
    public List<OrderInfo_wx> queryOrderInfoByIdNoPaied(Integer userId) {
        return orderMapper.queryOrderInfoByIdNoPaied(userId);
    }

    @Override
    public List<OrderInfo_wx> queryOrderInfoByIdNoShip(Integer userId) {
        return orderMapper.queryOrderInfoByIdNoShip(userId);
    }

    @Override
    public List<OrderInfo_wx> queryOrderInfoByIdNoReceive(Integer userId) {
        return orderMapper.queryOrderInfoByIdNoReceive(userId);
    }

    @Override
    public List<OrderInfo_wx> queryOrderInfoByIdNoComment(Integer userId) {
        return orderMapper.queryOrderInfoByIdNoComment(userId);
    }
}
