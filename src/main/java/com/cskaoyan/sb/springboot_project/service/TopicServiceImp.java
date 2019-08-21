package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Goods;
import com.cskaoyan.sb.springboot_project.bean.Topic;
import com.cskaoyan.sb.springboot_project.bean.Popularize.PopPage;
import com.cskaoyan.sb.springboot_project.mapper.GoodsMapper;
import com.cskaoyan.sb.springboot_project.mapper.TopicMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TopicServiceImp implements TopicService {

    @Autowired
    TopicMapper topicMapper;

    @Autowired
    GoodsMapper goodsMapper;

    /**
     * —— 查询所有 topic ——
     * 1、传入分页参数
     * 2、利用 mapper 进行查询
     */
    @Override
    public Map<String,Object> listTopic(PopPage popPage) {

        PageHelper.startPage(popPage.getPage(), popPage.getLimit());
        List<Topic> topics = topicMapper.listTopicByCondition(popPage.getSort(),popPage.getOrder());

        PageInfo<Topic> pageInfo = new PageInfo<>(topics);
        long total = pageInfo.getTotal();

        Map<String, Object> data = new HashMap<>();
        data.put("items", topics);
        data.put("total",total);

        return data;
    }

    @Override
    public Topic createTopic(Topic topic) {

        // 设置团购信息
        Date date = new Date();
        topic.setAddTime(date);
        topic.setUpdateTime(date);
        topic.setDeleted(false);

        int insert = topicMapper.insert(topic);

        if (insert > 0) {
            return topic;
        } else
            return null;
    }

    @Override
    public Topic updateTopic(Topic topic) {
        Date date = new Date();
        topic.setUpdateTime(date);



        int update = topicMapper.updateByPrimaryKey(topic);
        if (update > 0) {
            return topic;
        } else
            return null;
    }

    @Override
    public Map<String, Object> searchTopic(PopPage popPage, String title, String subtitle) {

        PageHelper.startPage(popPage.getPage(), popPage.getLimit());
        List<Topic> topics = topicMapper.searchTopicByCondition(popPage.getSort(),popPage.getOrder(),title,subtitle);

        PageInfo<Topic> pageInfo = new PageInfo<>(topics);
        long total = pageInfo.getTotal();

        Map<String, Object> data = new HashMap<>();
        data.put("items", topics);
        data.put("total",total);

        return data;
    }

    @Override
    public Topic readTopicById(String id) {

        Topic topic = topicMapper.selectByPrimaryKey(Integer.valueOf(id));

        return topic;
    }
}
