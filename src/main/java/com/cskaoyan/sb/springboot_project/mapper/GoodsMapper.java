package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Goods;
import org.apache.ibatis.annotations.Param;
import com.cskaoyan.sb.springboot_project.bean.Goods_statistics;

import java.util.List;

public interface GoodsMapper {
    List<Goods_statistics> query_goods_statistics();

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKeyWithBLOBs(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> queryAllGoodsList(@Param("goodsSn") Integer goodsSn, @Param("name") String name);//加载列表+模糊查询

    int updateDeleteById(Goods goods);//假删除

    Goods queryById(Integer id);

    List<String> queryCategoryIds(Integer id);

    int insertGoods(@Param("good") Goods goods);
}