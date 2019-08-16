package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Order_goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface Order_goodsMapper {
    int updateByPrimaryKeySelective(Order_goods record);

    int updateByPrimaryKey(Order_goods record);

    List<Order_goods> selectOrderGoodsListByOrderId(@Param("id") int id);
}