package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Admin;

public interface AdminMapper {
    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}