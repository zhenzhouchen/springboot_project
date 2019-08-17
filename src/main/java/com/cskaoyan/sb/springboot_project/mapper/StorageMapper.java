package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Storage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StorageMapper {
    int updateByPrimaryKeySelective(Storage record);

    int updateByPrimaryKey(Storage record);

    void InsertUploadFileInfo(Storage storage);
}