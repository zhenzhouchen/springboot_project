package com.cskaoyan.sb.springboot_project.controller;

import com.cskaoyan.sb.springboot_project.bean.Comment;
import com.cskaoyan.sb.springboot_project.service.CommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class CommentController {
    @Autowired
    CommentService commentService;

    @RequestMapping("/comment/list")
    @ResponseBody
    public Map<String, Object> queryAllCommentList(int page, int limit, Integer userId, Integer valueId) {
        PageHelper.startPage(page, limit);
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> info_map = new HashMap<>();
        List<Comment> items = commentService.queryAllCommentList(userId,valueId);
        PageInfo<Comment> userPageInfo = new PageInfo<>(items);
        info_map.put("items", items);
        long total = userPageInfo.getTotal();
        info_map.put("total", total);
        info_map.put("items", items);
        map.put("errmsg", "成功");
        map.put("errno", 0);
        map.put("data", info_map);
        return map;
    }

    @RequestMapping("/comment/delete")
    @ResponseBody
    public Map<String, Object> queryAllCommentListAfterDelete(@RequestBody Comment comment) {
        Map<String, Object> map = new HashMap<>();
        int i = commentService.updateDeleteById(comment);
        if (i == 1) {
            map.put("errmsg", "成功");
            map.put("errno", 0);
        }
        return map;
    }

    @RequestMapping("/order/reply")
    @ResponseBody
    public Map<String, Object> replyComment(@RequestBody Comment comment) {
        Map<String, Object> map = new HashMap<>();
        int i = commentService.queryCommentById(comment);
        if (i == 1) {
            map.put("errmsg", "订单商品已回复！");
            map.put("errno", 622);
        } else if (i == 0) {
            commentService.replyComment(comment);
            map.put("errmsg", "成功");
            map.put("errno", 0);
        }
        return map;
    }

}
