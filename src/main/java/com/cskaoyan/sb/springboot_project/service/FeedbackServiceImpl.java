package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Feedback;
import com.cskaoyan.sb.springboot_project.mapper.FeedbackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService{
    @Autowired
    FeedbackMapper feedbackMapper;

    @Override
    public List<Feedback> queryAllFeedbackList() {
        return feedbackMapper.queryAllFeedbackList();
    }

    @Override
    public List<Feedback> queryFeedbackList(String username, Integer id) {
        return feedbackMapper.queryFeedbackList(username,id);
    }
}
