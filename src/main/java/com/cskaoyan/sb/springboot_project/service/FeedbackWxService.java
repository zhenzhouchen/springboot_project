package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Feedback;
import com.cskaoyan.sb.springboot_project.bean.ResponseVo;

public interface FeedbackWxService {
    ResponseVo submitFeedback(Feedback feedback);
}
