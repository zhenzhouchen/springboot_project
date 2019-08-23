package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Feedback;
import com.cskaoyan.sb.springboot_project.bean.ResponseVo;
import com.cskaoyan.sb.springboot_project.mapper.FeedbackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FeedbackWxServiceImpl implements FeedbackWxService {

    @Autowired
    FeedbackMapper feedbackMapper;

    @Override
    public ResponseVo submitFeedback(Feedback feedback) {
        Date date = new Date();
        feedback.setAddTime(date);
        feedback.setUpdateTime(date);
        feedback.setStatus(0);
        feedback.setDeleted(false);
        if(!feedback.getHasPicture()) {
            feedback.setPicUrls(new String[]{""});
        }
        int result = feedbackMapper.submitWxFeedback(feedback);
        if(result == 1) {
            return new ResponseVo<>("成功", 0);
        }
        return new ResponseVo<>("失败", -1);
    }
}
