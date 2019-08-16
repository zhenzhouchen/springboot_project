package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Feedback;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FeedbackMapper {
    List<Feedback> queryAllFeedbackList();
    List<Feedback> queryFeedbackList(@Param("username") String username,@Param("id") Integer id);


    int updateByPrimaryKeySelective(Feedback record);

    int updateByPrimaryKey(Feedback record);
}