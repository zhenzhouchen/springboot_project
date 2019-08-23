package com.cskaoyan.sb.springboot_project.controller.wxcontroller;


import com.cskaoyan.sb.springboot_project.bean.Category;
import com.cskaoyan.sb.springboot_project.bean.CategoryList;
import com.cskaoyan.sb.springboot_project.bean.Goods;
import com.cskaoyan.sb.springboot_project.bean.Popularize.BaseResp;
import com.cskaoyan.sb.springboot_project.service.CategoryService;
import com.cskaoyan.sb.springboot_project.service.GoodsService;
import com.cskaoyan.sb.springboot_project.util.UserTokenManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.prism.impl.BaseResourcePool;
import org.mapstruct.MappingInheritanceStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("wx")
public class WxCategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    GoodsService goodsService;

    /*
        —— 显示类别 ——
    *   - 获得 类别 list
        - 获得 当前类别，默认 0
        - 获得 子类别 通过 pid 获得
    */
    @RequestMapping("catalog/index")
    public BaseResp<Map<String, Object>> index() {
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
            setErrorInfo(mapBaseResp, 0);
            return mapBaseResp;
        }

        return mapBaseResp;
    }

    /**
     * —— 类别详情 ——
     * 1、查询兄弟类别
     * 2、查询当前类别
     * 3、查询父类别
     */
    @RequestMapping("goods/category")
    public BaseResp<Map<String, Object>> goodsCates(int id) {
        Category category = categoryService.queryCategoryById(id);
        List<Category> brotherCates = categoryService.queryCategoryByPid(category);
        Category parentCate = categoryService.queryCategoryById(category.getPid());

        Map<String, Object> data = new HashMap<>();
        data.put("brotherCategory", brotherCates);
        data.put("currentCategory", category);
        data.put("parentCategory", parentCate);

        BaseResp<Map<String, Object>> mapBaseResp = null;
        if (category != null && brotherCates != null && parentCate != null) {
            mapBaseResp = new BaseResp<>();
            mapBaseResp.setData(data);
            setErrorInfo(mapBaseResp, 0);

            return mapBaseResp;
        }

        return mapBaseResp;
    }

    @RequestMapping("goods/detail")
    public BaseResp<Goods> goodsDetail(int id) {
        Goods goods = goodsService.queryById(id);

        BaseResp<Goods> mapBaseResp = null;
        if (goods != null) {
            mapBaseResp = new BaseResp<>();
            mapBaseResp.setData(goods);
            setErrorInfo(mapBaseResp, 0);

            return mapBaseResp;
        }

        return mapBaseResp;
    }

    /**
     * —— 查询相关商品 ——
     * 1、按照 id 的 categoryid 查询
     */
    @RequestMapping("goods/related")
    public BaseResp<Map<String, Object>> goodsRelated(int id) {
        Map<String,Object> data = goodsService.queryRelatedByCateId(id);
        BaseResp<Map<String, Object>> mapBaseResp = null;
        if (data != null) {
            mapBaseResp = new BaseResp<>();
            mapBaseResp.setData(data);
            mapBaseResp.setErrmsg("成功");
            mapBaseResp.setErrno(0);

            return mapBaseResp;
        }

        return mapBaseResp;
    }



    /*
        和 HomeIndex 重复
    @RequestMapping("goods/list")
    public BaseResp<Map<String, Object>> goodsList(int categoryId,int page,int size) {


        Map<String, Object> data = goodsService.queryGoodsById(categoryId, page, size);
        List<Category> filterCategoryList = categoryService.getFilterList(20);
        data.put("filterCategoryList", filterCategoryList);

        BaseResp<Map<String, Object>> baseRespMap = null;
        if (data != null) {
            baseRespMap = new BaseResp<>();
            baseRespMap.setData(data);
            setErrorInfo(baseRespMap,0);

            return baseRespMap;
        }

        return baseRespMap;
    }*/

    /**
     * —— 添加成功、失败信息 ——
     */
    private void setErrorInfo(BaseResp baseResp, int isError) {
        if (isError == 0) {
            baseResp.setErrmsg("成功");
            baseResp.setErrno(0);
        } else {
            baseResp.setErrmsg("失败");
            baseResp.setErrno(1);
        }
    }

}
