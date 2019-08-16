package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Order_config;
import org.apache.ibatis.annotations.Param;

public interface Order_configMapper {
    Order_config query_order_config();

    int update_order_config(@Param("order_config") Order_config order_config);
}
