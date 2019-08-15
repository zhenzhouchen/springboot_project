package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.System;

public interface SystemMapper {
    int updateByPrimaryKeySelective(System record);

    int updateByPrimaryKey(System record);
}