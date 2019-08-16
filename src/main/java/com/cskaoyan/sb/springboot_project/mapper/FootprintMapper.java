package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Footprint;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FootprintMapper {
    List<Footprint> queryAllFootprintList();
    List<Footprint> queryFootprintList(@Param("userId") Integer userId, @Param("goodsId") Integer goodsId);



    int updateByPrimaryKeySelective(Footprint record);

    int updateByPrimaryKey(Footprint record);
}