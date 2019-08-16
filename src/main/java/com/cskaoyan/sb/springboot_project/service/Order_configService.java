package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Order_config;

public interface Order_configService {
    Order_config query_order_config();
    int update_order_config(Order_config order_config);

}
