package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Storage;

public interface StorageMapper {
    int updateByPrimaryKeySelective(Storage record);

    int updateByPrimaryKey(Storage record);
}