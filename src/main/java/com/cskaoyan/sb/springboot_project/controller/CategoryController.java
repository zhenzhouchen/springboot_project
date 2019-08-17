package com.cskaoyan.sb.springboot_project.controller;


import com.cskaoyan.sb.springboot_project.bean.Category;
import com.cskaoyan.sb.springboot_project.bean.Order;
import com.cskaoyan.sb.springboot_project.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/list")
    @ApiOperation("获取category列表")
    public Map<String, Object> selectCategoryList() {
        List<Category> categoryList = categoryService.selectCategoryList();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("data", categoryList);
        hashMap.put("errmsg", "成功");
        hashMap.put("errno", 0);
        return hashMap;
    }

    @RequestMapping("/l1")
    @ApiOperation("获取一级类目")
    public Map<String, Object> selectLevel1List() {
        List<Map<String, Object>> data = categoryService.selectLevel1List();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("data", data);
        hashMap.put("errmsg", "成功");
        hashMap.put("errno", 0);
        return hashMap;
    }

    @RequestMapping("create")
    @ApiOperation("createCategory")
    public Map<String, Object> createCategory(@RequestBody Category category) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Category cg = categoryService.insertCategory(category);
        if(cg != null) {
            hashMap.put("data", cg);
            hashMap.put("errmsg", "成功");
            hashMap.put("errno", 0);
        }
        return hashMap;
    }

    @RequestMapping("update")
    @ApiOperation("updateCategory")
    public Map<String, Object> updateCategory(@RequestBody Category category) {
        HashMap<String, Object> hashMap = new HashMap<>();
        int i = categoryService.updateCategoryById(category);
        if(i == 1) {
            hashMap.put("errmsg", "成功");
            hashMap.put("errno", 0);
        }
        return hashMap;
    }

    @RequestMapping("delete")
    @ApiOperation("deleteCategory")
    public Map<String, Object> deleteCategory(@RequestBody Category category) {
        HashMap<String, Object> hashMap = new HashMap<>();
        int i = categoryService.deleteCategoryById(category);
        if(i == 1) {
            hashMap.put("errmsg", "成功");
            hashMap.put("errno", 0);
        }
        return hashMap;
    }
}
