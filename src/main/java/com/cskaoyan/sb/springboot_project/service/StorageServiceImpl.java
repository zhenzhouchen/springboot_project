package com.cskaoyan.sb.springboot_project.service;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import com.cskaoyan.sb.springboot_project.bean.Storage;
import com.cskaoyan.sb.springboot_project.mapper.StorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    StorageMapper storageMapper;

    @Override
    public Storage uploadFile(MultipartFile file) {
        Storage storage = new Storage();
        try {
            String uuid = UUID.randomUUID().toString();
            //获取文件名
            String originalFilename = file.getOriginalFilename();
            //获取文件格式
            String contentType = file.getContentType();
            //获取文件大小
            long size = file.getSize();
            //获取文件信息
            InputStream inputStream = file.getInputStream();
            //创建objectMetaData，并设置文件格式和大小
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(size);
            objectMetadata.setContentType(contentType);
            //设置AccessKeyID
            String accessKeyId = "LTAII6EdJxcTawlQ";
            String secretAccessKey = "WPoDAvl5NMkxHvFToJ1M8YzAfmjnF3";
            String endPoint = "oss-cn-beijing.aliyuncs.com";
            String buckeyName = "molycloud";
            String key = uuid.replace("-", "");//去掉uuid中的"-"，作为文件名
            //创建节点信息对象
            PutObjectRequest putObjectRequest = new PutObjectRequest(buckeyName, key, inputStream, objectMetadata);
            //创建上传地址及秘钥信息对象
            OSSClient ossClient = new OSSClient(endPoint, accessKeyId, secretAccessKey);
            //执行上传操作
            ossClient.putObject(putObjectRequest);
            //图片访问URL
            String url = "https://molycloud.oss-cn-beijing.aliyuncs.com/" + key;
            //存储上传信息
            Date date = new Date();
            storage.setAddTime(date);
            storage.setUpdateTime(date);
            storage.setKey(key);
            storage.setName(originalFilename);
            storage.setSize((int) size);
            storage.setType(contentType);
            storage.setUrl(url);
            storage.setDeleted(false);
            storageMapper.InsertUploadFileInfo(storage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return storage;
    }

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
