package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Feedback;

public interface FeedbackMapper {
    int updateByPrimaryKeySelective(Feedback record);

    int updateByPrimaryKey(Feedback record);
}