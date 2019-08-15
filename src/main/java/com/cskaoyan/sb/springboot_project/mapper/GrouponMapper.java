package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Groupon;

public interface GrouponMapper {
    int updateByPrimaryKeySelective(Groupon record);

    int updateByPrimaryKey(Groupon record);
}