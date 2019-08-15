package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Collect;

public interface CollectMapper {
    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);
}