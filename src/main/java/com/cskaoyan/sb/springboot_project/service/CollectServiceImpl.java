package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Collect;
import com.cskaoyan.sb.springboot_project.mapper.CollectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    CollectMapper collectMapper;

    @Override
    public List<Collect> queryCollectList(Integer userId, Integer valueId) {
        return collectMapper.queryCollectList(userId,valueId);
    }

    @Override
    public List<Collect> queryAllCollectList() {
        return collectMapper.queryAllCollectList();
    }
}
