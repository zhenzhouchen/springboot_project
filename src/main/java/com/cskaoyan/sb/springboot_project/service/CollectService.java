package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Collect;

import java.util.List;

public interface CollectService {
    List<Collect> queryCollectList(Integer userId,Integer valueId);

    List<Collect> queryAllCollectList();
}
