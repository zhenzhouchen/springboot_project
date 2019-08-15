package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Permission;

public interface PermissionMapper {
    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}