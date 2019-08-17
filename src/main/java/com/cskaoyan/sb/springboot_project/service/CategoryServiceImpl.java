package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Category;
import com.cskaoyan.sb.springboot_project.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> selectCategoryList() {
        return categoryMapper.selectCategoryList();
    }

    @Override
    public List<Map<String, Object>> selectLevel1List() {
        List<Category> level1List = categoryMapper.selectLevel1List();
        List<Map<String, Object>> mapList = new ArrayList<>();
        for (Category category : level1List) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("label", category.getName());
            hashMap.put("value", category.getId());
            mapList.add(hashMap);
        }
        return mapList;
    }
}
