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
    public List<Collect> queryCollectList(Integer userId, Integer valueId,String sort,String order) {
        return collectMapper.queryCollectList(userId,valueId,sort,order);
    }

    @Override
    public List<Collect> queryAllCollectList(String sort,String order) {
        return collectMapper.queryAllCollectList(sort, order);
    }
}
