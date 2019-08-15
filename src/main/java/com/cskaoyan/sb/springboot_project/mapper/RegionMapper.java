package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Region;

public interface RegionMapper {
    int updateByPrimaryKeySelective(Region record);

    int updateByPrimaryKey(Region record);
}