package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.GoodsList;
import org.apache.ibatis.annotations.Param;

public interface GoodsListMapper {
    GoodsList[] queryGoodsList(@Param("orderId") Integer orderId);
}
