package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Brand;
import com.cskaoyan.sb.springboot_project.mapper.BrandMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandMapper brandMapper;

    @Override
    public Map<String, Object> selectBrandList(int page, int limit, Integer id, String name, String add_time, String order) {
        PageHelper.startPage(page, limit);
        List<Brand> brandList = brandMapper.selectBrandList(page, limit, id, name, add_time, order);
        PageInfo<Brand> brandPageInfo = new PageInfo<>(brandList);
        long total = brandPageInfo.getTotal();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("items", brandList);
        hashMap.put("total", total);
        return hashMap;
    }
}
