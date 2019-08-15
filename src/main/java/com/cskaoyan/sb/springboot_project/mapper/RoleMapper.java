package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Role;

public interface RoleMapper {
    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}