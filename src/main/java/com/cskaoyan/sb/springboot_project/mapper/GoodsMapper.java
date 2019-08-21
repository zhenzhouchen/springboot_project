package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Goods;
import org.apache.ibatis.annotations.Param;
import com.cskaoyan.sb.springboot_project.bean.Goods_statistics;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsMapper {
    List<Goods_statistics> query_goods_statistics();

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKeyWithBLOBs(Goods record);

    int updateByPrimaryKey(@Param("good")Goods record);//更新商品信息

    List<Goods> queryAllGoodsList(@Param("goodsSn") Integer goodsSn, @Param("name") String name);//加载列表+模糊查询

    int updateDeleteById(Goods goods);//假删除

    Goods queryById(Integer id);//编辑回显

    Integer queryCategoryIds(Integer id);

    int insertGoods(@Param("good") Goods goods);//商品上架

    int queryByIdReturnInt(Integer id);//插入前判断是否已经存在
    @Select("select goods_sn, name form cskaoyan_mall_goods where goods_id = #{goodsId}")
    Goods selectGoodByGoodsId(@Param("goodsId") Integer goodsId);
}