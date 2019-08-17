package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Storage;
import com.cskaoyan.sb.springboot_project.mapper.StorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    StorageMapper storageMapper;

    public List<Storage> queryAllStorageList(String sort, String order) {
        return storageMapper.queryAllStorageList(sort, order);
    }

    @Override
    public List<Storage> queryStorageList(String key, String name, String sort, String order) {
        return storageMapper.queryStorageList(key, name, sort, order);
    }

    @Override
    public int update_storage(Storage storage) {
        return storageMapper.update_storage(storage);
    }

    @Override
    public int delete_storage(Storage storage) {
        return storageMapper.delete_storage(storage);
    }
}
