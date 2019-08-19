package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Goods;
import org.apache.ibatis.annotations.Param;
import com.cskaoyan.sb.springboot_project.bean.Goods_statistics;

import java.util.List;

public interface GoodsMapper {
    List<Goods_statistics> query_goods_statistics();

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKeyWithBLOBs(Goods record);

    int updateByPrimaryKey(@Param("good")Goods record);//更新商品信息

    List<Goods> queryAllGoodsList(@Param("goodsSn") Integer goodsSn, @Param("name") String name);//加载列表+模糊查询

    int updateDeleteById(Goods goods);//假删除

    Goods queryById(Integer id);//编辑回显

    List<String> queryCategoryIds(Integer id);

    int insertGoods(@Param("good") Goods goods);//商品上架
}