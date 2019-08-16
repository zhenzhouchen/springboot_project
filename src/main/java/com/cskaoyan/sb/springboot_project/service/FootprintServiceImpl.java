package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Footprint;
import com.cskaoyan.sb.springboot_project.mapper.FootprintMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootprintServiceImpl implements FootprintService {
    @Autowired
    FootprintMapper footprintMapper;

    @Override
    public List<Footprint> queryAllFootprintList(String sort,String order) {
        return footprintMapper.queryAllFootprintList(sort, order);
    }

    @Override
    public List<Footprint> queryFootprintList(Integer userId, Integer goodsId,String sort,String order) {
        return footprintMapper.queryFootprintList(userId,goodsId,sort,order);
    }
}
