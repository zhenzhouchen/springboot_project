package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Order;
import com.cskaoyan.sb.springboot_project.bean.User;
import com.cskaoyan.sb.springboot_project.mapper.OrderMapper;
import com.cskaoyan.sb.springboot_project.mapper.Order_goodsMapper;
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
    User user;

    @Override
    public Map<String, Object> selectOrderList(int page, int limit, Integer[] orderStatusArray, String add_time, String order, Integer userId, String orderSn) {
        PageHelper.startPage(page, limit);
        List<Order> orderList = orderMapper.selectOrderList(page, limit, orderStatusArray, add_time, order, userId, orderSn);
        PageInfo<Order> orderPageInfo = new PageInfo<>(orderList);
        long total = orderPageInfo.getTotal();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("items", orderList);
        hashMap.put("total", total);
        return hashMap;
    }

    @Override
    public Map<String, Object> selectOrderDetailById(int id) {
        return null;
    }
}
