package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Brand;

public interface BrandMapper {
    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);
}