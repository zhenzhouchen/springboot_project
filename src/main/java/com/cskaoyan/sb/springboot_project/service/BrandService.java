package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Brand;

import java.util.Map;

public interface BrandService {
    Map<String, Object> selectBrandList(int page, int limit, Integer id, String name, String sort, String order);

    Brand insertBrand(Brand brand);

    int deleteBrandById(Brand brand);

    int updateBrandById(Brand brand);
}
