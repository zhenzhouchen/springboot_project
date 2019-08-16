package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Feedback;

import java.util.List;

public interface FeedbackService {
    List<Feedback> queryAllFeedbackList(String sort,String order);
    List<Feedback> queryFeedbackList(String username,Integer id,String sort,String order);

}
