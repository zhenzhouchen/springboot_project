package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Order;

public interface OrderMapper {
    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}