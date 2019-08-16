package com.cskaoyan.sb.springboot_project.service;

import java.util.Map;

public interface BrandService {
    Map<String, Object> selectBrandList(int page, int limit, Integer id, String name, String add_time, String order);
}
