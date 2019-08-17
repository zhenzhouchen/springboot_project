package com.cskaoyan.sb.springboot_project.controller;

import com.cskaoyan.sb.springboot_project.bean.Region;
import com.cskaoyan.sb.springboot_project.service.RegionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/admin")
@RestController
@Api("region")
public class RegionController {

    @Autowired
    RegionService regionService;

    @RequestMapping("/region/list")
    @ApiOperation(value = "显示region列表")
    public Map<String, Object> selectRegionList() {
        List<Region> regionList = regionService.selectRegionList();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("errno", 0);
        hashMap.put("data", regionList);
        return hashMap;
    }
}
