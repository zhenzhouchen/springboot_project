package com.cskaoyan.sb.springboot_project.controller.wxcontroller;


import com.cskaoyan.sb.springboot_project.bean.Category;
import com.cskaoyan.sb.springboot_project.bean.CategoryList;
import com.cskaoyan.sb.springboot_project.bean.Popularize.BaseResp;
import com.cskaoyan.sb.springboot_project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RestController
@RequestMapping("wx")
public class WxCategoryController {

    @Autowired
    CategoryService categoryService;

    /*
        —— 显示类别 ——
    *   - 获得 类别 list
        - 获得 当前类别，默认 0
        - 获得 子类别 通过 pid 获得
    */
    @RequestMapping("catalog/index")
    public BaseResp<Map<String, Object>> index(){
        List<Category> categories = categoryService.selectCategoryList();
        Category category = categoryService.queryCategoryById(categories.get(0).getId());
        List<Category> subcategories = categoryService.queryCategoryByPid(category);

        Map<String, Object> data = new HashMap<>();
        data.put("categoryList", categories);
        data.put("currentCategory", category);
        data.put("currentSubCategory", subcategories);

        BaseResp<Map<String, Object>> mapBaseResp = null;
        if (categories != null || category != null || subcategories != null) {

            mapBaseResp = new BaseResp<>();
            mapBaseResp.setData(data);
            mapBaseResp.setErrmsg("成功");
            mapBaseResp.setErrno(0);
            return mapBaseResp;
        }

        return mapBaseResp;
    }


    /**
     * —— 查询当前类别 ——
     * 1、返回当前类别
     * 2、返回子类别
     */
    @RequestMapping("catalog/current")
    public BaseResp<Map<String, Object>> current(int id) {
        Category category = categoryService.queryCategoryById(id);
        List<Category> categories = categoryService.queryCategoryByPid(category);

        Map<String, Object> data = new HashMap<>();
        data.put("currentCategory", category);
        data.put("currentSubCategory", categories);

        BaseResp<Map<String, Object>> mapBaseResp = null;
        if (categories != null || category != null) {
            mapBaseResp = new BaseResp<>();
            mapBaseResp.setData(data);
            mapBaseResp.setErrno(0);
            mapBaseResp.setErrmsg("成功");
            return mapBaseResp;
        }

        return mapBaseResp;
    }


}