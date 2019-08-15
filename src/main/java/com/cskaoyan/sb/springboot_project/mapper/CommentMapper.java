package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Comment;

public interface CommentMapper {
    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}