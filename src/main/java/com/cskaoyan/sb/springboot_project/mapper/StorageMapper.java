package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Storage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StorageMapper {
    List<Storage> queryAllStorageList(@Param("sort") String sort,@Param("order") String order);

    List<Storage> queryStorageList(@Param("key") String key, @Param("name") String name, @Param("sort") String sort, @Param("order") String order);

    int update_storage(@Param("storage") Storage storage);

    int delete_storage(@Param("storage") Storage storage);
}