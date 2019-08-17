package com.cskaoyan.sb.springboot_project.controller;

import com.cskaoyan.sb.springboot_project.bean.Storage;
import com.cskaoyan.sb.springboot_project.service.StorageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;


@RequestMapping("/admin/storage")
@RestController
public class StorageController {

    @Autowired
    StorageService storageService;

    @RequestMapping("create")
    @ApiOperation("uploadFile")
    public Map<String, Object> uploadFile(MultipartFile file) {
        Storage storage = storageService.uploadFile(file);
        HashMap<String, Object> hashMap = new HashMap<>();
        if(storage != null) {
            hashMap.put("data", storage);
            hashMap.put("errmsg", "成功");
            hashMap.put("errno", 0);
        } else {
            hashMap.put("errmsg", "失败");
            hashMap.put("errno", 1);
        }
        return hashMap;
    }
}
