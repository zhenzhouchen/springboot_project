package com.cskaoyan.sb.springboot_project.service;


import com.cskaoyan.sb.springboot_project.bean.Storage;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    Storage uploadFile(MultipartFile file);
}
