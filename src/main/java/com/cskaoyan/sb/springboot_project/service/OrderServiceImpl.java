package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Order;
import com.cskaoyan.sb.springboot_project.bean.Order_goods;
import com.cskaoyan.sb.springboot_project.bean.User;
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
}
