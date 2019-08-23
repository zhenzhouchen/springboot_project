package com.cskaoyan.sb.springboot_project.service;


import com.cskaoyan.sb.springboot_project.bean.Comment;
import com.cskaoyan.sb.springboot_project.bean.Topic;

import java.util.List;
import java.util.Map;

public interface WxHomeIndexService {
    Map<String, Object> queryAllIndexList();

    List<Integer> goodsCount();

    Map<String, Object> searchGoods();

    Map<String, Object> searchGoodslist(String keyword);

    List<String> searchHelper(String keyword);

    void updateSearchHistory(Integer userId, String keyword);

    int clearHistory(Integer userId);

    Map<String, Object> couponMyList();

    Map<String, Object> topicDetail(Integer id);

    List<Topic> topicRelated(Integer id);

    Map<String, Object> commentList(Integer page, Integer valueId);

    Comment commentPost(Comment comment);

    Map<String, Object> commentCount(Integer valueId);
}
