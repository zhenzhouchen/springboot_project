package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.User;

public interface UserMapper {
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}