package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Footprint;

public interface FootprintMapper {
    int updateByPrimaryKeySelective(Footprint record);

    int updateByPrimaryKey(Footprint record);
}