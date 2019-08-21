package com.cskaoyan.sb.springboot_project.controller;

import com.cskaoyan.sb.springboot_project.bean.*;
import com.cskaoyan.sb.springboot_project.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@MapperScan("com.cskaoyan.sb.springboot_project.mapper")
@RestController
@RequestMapping("/admin")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @Autowired
    Goods_attributeService goodsAttributeService;

    @Autowired
    Goods_productService goodsProductService;

    @Autowired
    Goods_specificationService goodsSpecificationService;

    @Autowired
    BrandService brandService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/goods/list")
    @ResponseBody
    public Map<String, Object> queryAllGoodsList(int page, int limit, Integer goodsSn, String name) {
        PageHelper.startPage(page, limit);
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> info_map = new HashMap<>();
        List<Goods> items = goodsService.queryAllGoodsList(goodsSn, name);
        PageInfo<Goods> userPageInfo = new PageInfo<>(items);
        long total = userPageInfo.getTotal();
        info_map.put("total", total);
        info_map.put("items", items);
        map.put("errmsg", "成功");
        map.put("errno", 0);
        map.put("data", info_map);
        return map;
    }

    @RequestMapping("/goods/delete")
    @ResponseBody
    public Map<String, Object> queryAllGoodsListAfterDelete(@RequestBody Goods Goods) {
        Map<String, Object> map = new HashMap<>();
        int i = goodsService.updateDeleteById(Goods);
        if (i > 0) {
            map.put("errmsg", "成功");
            map.put("errno", 0);
        }
        return map;
    }

    @RequestMapping("goods/detail")
    @ResponseBody
    public Map<String, Object> updateGoodsDetail(Integer id) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> info_map = new HashMap<>();
        Goods goods = goodsService.queryById(id);
        List<Goods_attribute> attributes = goodsAttributeService.queryByGoodsId(id);
        List<Goods_product> products = goodsProductService.queryByGoodsId(id);
        List<Goods_specification> specifications = goodsSpecificationService.queryByGoodsId(id);
        Integer categorySonId = goodsService.queryCategoryIds(id);
        Integer categoryfatherId = categoryService.queryCategoryIds(categorySonId);
        List<Integer> categoryIds = new ArrayList<>();
        categoryIds.add(categoryfatherId);
        categoryIds.add(categorySonId);
        info_map.put("goods", goods);
        info_map.put("attributes", attributes);
        info_map.put("products", products);
        info_map.put("specifications", specifications);
        info_map.put("categoryIds", categoryIds);
        map.put("errmsg", "成功");
        map.put("errno", 0);
        map.put("data", info_map);
        return map;
    }

    @ResponseBody
    @RequestMapping("goods/catAndBrand")
    public Map<String, Object> queryCatAndBrandList(Integer id) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> info_map = new HashMap<>();
        List<Brand> brandList = brandService.brandList();
        List<CategoryList> categoryList = categoryService.CategoryListlevel1();
        info_map.put("brandList", brandList);
        info_map.put("categoryList", categoryList);
        map.put("errmsg", "成功");
        map.put("errno", 0);
        map.put("data", info_map);
        return map;
    }

    @ResponseBody
    @RequestMapping("goods/create")
    public Map<String, Object> goodsCreate(@RequestBody Goods_create create) {
        Map<String, Object> map = new HashMap<>();
        int tag = goodsService.queryByIdReturnInt(Integer.valueOf(create.getGoods().getGoodsSn()));
        if (tag != 0){
            map.put("errmsg", "商品名已经存在");
            map.put("errno", 611);
        }else {
            int i = goodsService.insertGoods(create.getGoods());
            if (i == 1) {
                if (create.getAttributes().size() > 0) {
                    goodsAttributeService.insertAttribute(create.getAttributes(), create.getGoods());
                }
                if (create.getProducts().size() > 0) {
                    goodsProductService.insertProduct(create.getProducts(), create.getGoods());
                }
                if (create.getSpecifications().size() > 0) {
                    goodsSpecificationService.insertSpecification(create.getSpecifications(), create.getGoods());
                }
                map.put("errmsg", "成功");
                map.put("errno", 0);
            }
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("goods/update")
    public Map<String, Object> goodsUpdate(@RequestBody Goods_create update) {
        Map<String, Object> map = new HashMap<>();
        int i = goodsService.updateGoods(update.getGoods());
        if (i == 1) {
            goodsAttributeService.updateAttribute(update);
            goodsSpecificationService.updateSpecification(update);
            goodsProductService.updateProduct(update);
            map.put("errmsg", "成功");
            map.put("errno", 0);
        }
        return map;
    }
}
