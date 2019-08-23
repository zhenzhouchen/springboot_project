package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Region;
import com.cskaoyan.sb.springboot_project.mapper.RegionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    RegionMapper regionMapper;

    @Override
    public List<Region> selectRegionList() {
        return regionMapper.selectRegionList();
    }

    @Override
    public List<Region> queryRegion(int pid) {
        return regionMapper.queryRegion(pid);
    }
}
