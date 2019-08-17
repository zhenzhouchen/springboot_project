package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Category;

import java.util.List;
import java.util.Map;

public interface CategoryService {
    List<Category> selectCategoryList();

    List<Map<String, Object>> selectLevel1List();

    Category insertCategory(Category category);

    int updateCategoryById(Category category);

    int deleteCategoryById(Category category);
}
