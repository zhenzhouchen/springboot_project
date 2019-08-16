package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Footprint;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FootprintMapper {
    List<Footprint> queryAllFootprintList(@Param("sort") String sort,@Param("order") String order);
    List<Footprint> queryFootprintList(@Param("userId") Integer userId, @Param("goodsId") Integer goodsId,@Param("sort") String sort,@Param("order") String order);



    int updateByPrimaryKeySelective(Footprint record);

    int updateByPrimaryKey(Footprint record);
}