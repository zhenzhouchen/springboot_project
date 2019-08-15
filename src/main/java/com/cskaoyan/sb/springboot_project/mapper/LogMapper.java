package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Log;

public interface LogMapper {
    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);
}