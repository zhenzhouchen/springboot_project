package com.cskaoyan.sb.springboot_project.controller;

import com.cskaoyan.sb.springboot_project.bean.Brand;
import com.cskaoyan.sb.springboot_project.service.BrandService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public Map<String, Object> selectBrandList(int page, int limit, Integer id, String name, String sort, String order) {
        Map<String, Object> brandMap = brandService.selectBrandList(page, limit, id, name, sort, order);
        HashMap<String, Object> msgMap = new HashMap<>();
        msgMap.put("data", brandMap);
        msgMap.put("errmsg", "成功");
        msgMap.put("errno", 0);
        return msgMap;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ApiOperation("updateBrand")
    public Map<String, Object> updateBrandById(@RequestBody Brand brand) {
        HashMap<String, Object> hashMap = new HashMap<>();
        int i = brandService.updateBrandById(brand);
        if(i == 1) {
            hashMap.put("data", brand);
            hashMap.put("errmsg", "成功");
            hashMap.put("errno", 0);
        }
        return hashMap;
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ApiOperation("deleteBrand")
    public Map<String, Object> deleteKeywordById(@RequestBody Brand brand) {
        HashMap<String, Object> hashMap = new HashMap<>();
        int i = brandService.deleteBrandById(brand);
        if(i == 1) {
            hashMap.put("errmsg", "成功");
            hashMap.put("errno", 0);
        }
        return hashMap;
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ApiOperation("createBrand")
    public Map<String, Object> createBrand(@RequestBody Brand brand) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Brand bd = brandService.insertBrand(brand);
        if(bd != null) {
            hashMap.put("data", bd);
            hashMap.put("errmsg", "成功");
            hashMap.put("errno", 0);
        }
        return hashMap;
    }
}
