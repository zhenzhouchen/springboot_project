package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Goods;
import com.cskaoyan.sb.springboot_project.bean.Goods_attribute;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Goods_attributeMapper {
    int updateByPrimaryKeySelective(Goods_attribute record);

    int updateByPrimaryKey(Goods_attribute record);

    List<Goods_attribute> queryByGoodsId(Integer goodsId);

    int insertAttribute(@Param("attributes") List<Goods_attribute> attributes);

    int deleteAttribute(@Param("goods") Goods goods);

//    List<Integer> queryDeleteId(Goods goods);//查找修改前商品的全部参数ID
}