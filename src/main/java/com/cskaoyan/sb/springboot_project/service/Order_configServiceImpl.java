package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Order_config;
import com.cskaoyan.sb.springboot_project.mapper.Order_configMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Order_configServiceImpl implements Order_configService {
    @Autowired
    Order_configMapper order_configMapper;
    @Override
    public Order_config query_order_config() {
        return order_configMapper.query_order_config();
    }

    @Override
    public int update_order_config(Order_config order_config) {
        return order_configMapper.update_order_config(order_config);
    }
}
