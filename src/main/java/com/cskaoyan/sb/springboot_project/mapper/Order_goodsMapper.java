package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Order_goods;

public interface Order_goodsMapper {
    int updateByPrimaryKeySelective(Order_goods record);

    int updateByPrimaryKey(Order_goods record);
}