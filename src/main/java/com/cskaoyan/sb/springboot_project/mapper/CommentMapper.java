package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {
    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    List<Comment> queryAllCommentList(@Param("userId") Integer userId, @Param("valueId") Integer valueId);

    int updateDeleteById(Comment comment);

    int replyComment(Comment comment);

    Comment queryCommentById(Comment comment);
}