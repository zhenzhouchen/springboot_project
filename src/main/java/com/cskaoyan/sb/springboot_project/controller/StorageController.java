package com.cskaoyan.sb.springboot_project.controller;

import com.cskaoyan.sb.springboot_project.bean.Storage;
import com.cskaoyan.sb.springboot_project.service.StorageService;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class StorageController {
    @Autowired
    StorageService storageService;

    @RequestMapping("storage/create")
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

    @RequestMapping("storage/list")
    public Map<String,Object> query_storge_list(int page,int limit,String key,String name,String sort,String order){
        PageHelper.startPage(page,limit);
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> map_info = new HashMap<>();
        List<Storage> items =null;
        if(key == null && name == null){
            items = storageService.queryAllStorageList(sort,order);
        }else{
            items = storageService.queryStorageList(key,name,sort,order);

        }
        map_info.put("items",items);
        map.put("data",map_info);
        map.put("errmsg","成功");
        map.put("errno",0);
        return map;
    }

    //该请求只修改对象名称name
    @RequestMapping("storage/update")
    public Map<String,Object> update_storage(@RequestBody Storage storage ){
        Map<String,Object> map = new HashMap<>();
        int result = storageService.update_storage(storage);
        if(result==1) {
            map.put("errmsg", "成功");
        }
        map.put("errno",0);
        return map;
    }

    @RequestMapping("storage/delete")
    public Map<String,Object> delete_storage(@RequestBody Storage storage ){
        Map<String,Object> map = new HashMap<>();
        int result = storageService.delete_storage(storage);
        if(result==1) {
            map.put("errmsg", "成功");
        }
        map.put("errno",0);
        return map;
    }

}
