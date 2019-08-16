package com.cskaoyan.sb.springboot_project.controller;

import com.cskaoyan.sb.springboot_project.service.BrandService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/brand")
public class BrandController {

    @Autowired
    BrandService brandService;

    @RequestMapping("/list")
    @ApiOperation(value = "获取brand列表")
    public Map<String, Object> selectBrandList(int page, int limit, Integer id, String name, String add_time, String order) {
        Map<String, Object> brandMap = brandService.selectBrandList(page, limit, id, name, add_time, order);
        HashMap<String, Object> msgMap = new HashMap<>();
        msgMap.put("data", brandMap);
        msgMap.put("errmsg", "成功");
        msgMap.put("errno", 0);
        return msgMap;
    }
}
