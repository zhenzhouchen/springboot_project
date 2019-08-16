package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Litemall;
import com.cskaoyan.sb.springboot_project.mapper.ConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigServiceImpl implements ConfigService {
    @Autowired
    ConfigMapper configMapper;
    @Override
    public Litemall query_litemall() {
        return configMapper.query_litemall();
    }

    @Override
    public int update_litemall(Litemall litemall) {
        return configMapper.update_litemall(litemall);
    }
}
