package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Cart;

public interface CartMapper {
    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);
}