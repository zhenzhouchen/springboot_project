package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Ad;

public interface AdMapper {
    int updateByPrimaryKeySelective(Ad record);

    int updateByPrimaryKey(Ad record);
}