package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.User_formid;

public interface User_formidMapper {
    int updateByPrimaryKeySelective(User_formid record);

    int updateByPrimaryKey(User_formid record);
}