package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Comment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CommentMapper {
    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    List<Comment> queryAllCommentList(@Param("userId") Integer userId, @Param("valueId") Integer valueId);

    int updateDeleteById(Comment comment);

    int replyComment(Comment comment);

    Comment queryCommentById(Comment comment);

    int selectCount(Integer valueId);

    List<Comment> queryCommentListByValueId(Integer valueId);

    int insertComment(Comment comment);

    Comment selectCommentById(Integer id);

    int hasPicCountCount(Integer valueId);

    List<Comment> queryCommentByUserId(@Param("goodsId") int goodsId);
    @Select("select count(id) from cskaoyan_mall_comment where value_id = #{goodsId}")
    int queryCommentCount(@Param("goodsId") int goodsId);

}