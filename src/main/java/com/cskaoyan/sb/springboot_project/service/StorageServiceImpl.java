package com.cskaoyan.sb.springboot_project.service;


import com.cskaoyan.sb.springboot_project.bean.Storage;
import com.cskaoyan.sb.springboot_project.mapper.StorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    StorageMapper storageMapper;

    @Override
    public Storage uploadFile(MultipartFile file) {
        String uuid = UUID.randomUUID().toString();
        //获取文件名
        String originalFilename = file.getOriginalFilename();
        /*String hexString = Integer.toHexString((uuid + originalFilename).hashCode());*/
        //获取扩展名
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //获取随机key(生成文件名及扩展名)
        String key = uuid + suffix;
        //文件上传路径
        /*String filePath = "http://localhost:80/wx/storage/fetch/" + key;*/
        /*String filePath = "http://yanxuan.nosdn.127.net/" + key;*/
        String classpath = "";
        try {
            classpath = ResourceUtils.getURL("classpath:").getPath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String filePath = classpath + "/static/uploading/" + key;
        File receiveFile = new File(filePath);
        if(!receiveFile.getParentFile().exists()) {
            receiveFile.getParentFile().mkdirs();
        }
        Storage storage = null;
        try {
            file.transferTo(receiveFile);
            storage = new Storage();
            Date date = new Date();
            storage.setAddTime(date);
            storage.setUpdateTime(date);
            storage.setKey(key);
            storage.setName(originalFilename);
            storage.setSize((int) file.getSize());
            storage.setType(file.getContentType());
            storage.setUrl("/img/" + key);
            storage.setDeleted(false);
            storageMapper.InsertUploadFileInfo(storage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return storage;
    }
}
