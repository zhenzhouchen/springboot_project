package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Comment;
import com.cskaoyan.sb.springboot_project.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Override
    public List<Comment> queryAllCommentList(Integer userId, Integer valueId) {
        List<Comment> comments = commentMapper.queryAllCommentList(userId,valueId);
        return comments;
    }

    @Override
    public int updateDeleteById(Comment comment) {
        return commentMapper.updateDeleteById(comment);
    }

    @Override
    public int replyComment(Comment comment) {
        return commentMapper.replyComment(comment);
    }

    @Override
    public int queryCommentById(Comment comment) {
        Comment comment1 = commentMapper.queryCommentById(comment);
        String content = comment1.getContent();
        if (content == null) {
            return 0;
        }
        return 1;
    }
}
