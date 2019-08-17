package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Category;
import com.cskaoyan.sb.springboot_project.bean.CategoryList;

import java.util.List;
import java.util.Map;

public interface CategoryService {
    List<Category> selectCategoryList();

    List<Map<String, Object>> selectLevel1List();

    List<CategoryList> CategoryListlevel1();

    Category insertCategory(Category category);

    int updateCategoryById(Category category);

    int deleteCategoryById(Category category);
}
