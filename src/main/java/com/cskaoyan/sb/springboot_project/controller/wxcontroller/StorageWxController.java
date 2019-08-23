package com.cskaoyan.sb.springboot_project.controller.wxcontroller;

import com.cskaoyan.sb.springboot_project.bean.ResponseVo;
import com.cskaoyan.sb.springboot_project.bean.Storage;
import com.cskaoyan.sb.springboot_project.service.StorageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("wx/storage")
@RestController
public class StorageWxController {

    @Autowired
    StorageService storageService;

    @RequestMapping("upload")
    @ApiOperation("uploadWx")
    public ResponseVo<Storage> uploadWx(MultipartFile file) {
        Storage storage = storageService.uploadFile(file);
        if(storage != null) {
            return new ResponseVo<Storage>(storage, "成功", 0);
        } else {
            return new ResponseVo<Storage>("失败", -1);
        }
    }
}
