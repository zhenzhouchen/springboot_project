package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Popularize.PopPage;
import com.cskaoyan.sb.springboot_project.bean.Topic;

import java.util.Map;

public interface TopicService {
    Map<String,Object> listTopic(PopPage popPage);

    Topic createTopic(Topic topic);

    Topic updateTopic(Topic topic);

    Map<String, Object> searchTopic(PopPage popPage, String title,String subtitle);

    Topic readTopicById(String id);
}
