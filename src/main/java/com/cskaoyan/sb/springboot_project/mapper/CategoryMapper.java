package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Category;

public interface CategoryMapper {
    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}