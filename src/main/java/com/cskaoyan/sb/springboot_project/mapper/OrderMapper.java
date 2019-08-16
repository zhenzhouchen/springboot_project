package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> selectOrderList(int page, int limit, @Param("statusArray") Integer[] orderStatusArray, @Param("addTime") String add_time, @Param("order") String order, @Param("userId") Integer userId, @Param("orderSn") String orderSn);
}