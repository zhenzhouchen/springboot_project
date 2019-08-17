package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Category;
import com.cskaoyan.sb.springboot_project.bean.CategoryList;
import com.cskaoyan.sb.springboot_project.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Override
    public List<CategoryList> CategoryListlevel1() {
        List<CategoryList> list = categoryMapper.CategoryListlevel1();
        return list;
    }

    @Override
    public Category insertCategory(Category category) {
        category.setDeleted(false);
        Date date = new Date();
        category.setAddTime(date);
        category.setUpdateTime(date);
        int i = categoryMapper.insertCategory(category);
        if(i == 1) {
            return category;
        } {
            return null;
        }
    }

    @Override
    public int updateCategoryById(Category category) {
        Date date = new Date();
        category.setUpdateTime(date);
        return categoryMapper.updateCategoryById(category);
    }

    @Override
    public int deleteCategoryById(Category category) {
        return categoryMapper.deleteCategoryById(category);
    }
}
