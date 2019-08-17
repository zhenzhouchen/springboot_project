package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Order;
import com.cskaoyan.sb.springboot_project.bean.Order_statistics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> selectOrderList(int page, int limit, @Param("statusArray") Integer[] orderStatusArray, @Param("sort") String sort, @Param("order") String order, @Param("userId") Integer userId, @Param("orderSn") String orderSn);

    Order selectOrderDetailByOrderId(@Param("id") int id);

    List<Order_statistics> query_order_statistics();

}