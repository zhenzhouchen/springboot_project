package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Footprint;

import java.util.List;

public interface FootprintService {
    List<Footprint> queryAllFootprintList();
    List<Footprint> queryFootprintList(Integer userId, Integer goodsId);

}
