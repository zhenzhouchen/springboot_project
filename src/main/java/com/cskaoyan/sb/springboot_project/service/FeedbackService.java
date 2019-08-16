package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Feedback;

import java.util.List;

public interface FeedbackService {
    List<Feedback> queryAllFeedbackList();
    List<Feedback> queryFeedbackList(String username,Integer id);

}
