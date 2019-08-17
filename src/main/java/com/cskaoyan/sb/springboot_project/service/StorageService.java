package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Storage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StorageService {
    List<Storage> queryAllStorageList(String sort, String order);

    List<Storage> queryStorageList(String key, String name, String sort, String order);

    int update_storage(Storage storage);

    int delete_storage(Storage storage);

    Storage uploadFile(MultipartFile file);
}
