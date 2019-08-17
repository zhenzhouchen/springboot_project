package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> queryAllCommentList(Integer userId, Integer valueId);

    int updateDeleteById(Comment comment);

    int replyComment(Comment comment);

    int queryCommentById(Comment comment);
}
