package com.cskaoyan.sb.springboot_project.controller.popluarizeController;


import com.cskaoyan.sb.springboot_project.bean.Topic;
import com.cskaoyan.sb.springboot_project.bean.Popularize.BaseResp;
import com.cskaoyan.sb.springboot_project.bean.Popularize.PopPage;
import com.cskaoyan.sb.springboot_project.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
@RequestMapping("admin")
@RestController
public class TopicController {

    @Autowired
    TopicService topicService;

    /**
     * —— 查询内容、模糊查询 ——
     * 1、判断是否有 name、content，
     *      可以在这里判断，也可以直接在数据库底层 if test判断
     */
    @RequestMapping("topic/list")
    public BaseResp<Map<String, Object>> listTopic(PopPage popPage, String title, String subtitle) {


        Map<String, Object> topicResult = null;
        if (title != null || subtitle != null) {
            topicResult = topicService.searchTopic(popPage, title,subtitle);
        } else {
            topicResult = topicService.listTopic(popPage);
        }

        BaseResp<Map<String, Object>> topicPopBaseResp = new BaseResp<>();
        if (topicResult == null) {
            setErrorInfo(topicPopBaseResp, 1);
        } else {
            topicPopBaseResp.setData(topicResult);
            setErrorInfo(topicPopBaseResp, 0);
        }

        return topicPopBaseResp;
    }


    /**
     * —— 添加 topic ——
     */
    @RequestMapping("topic/create")
    public BaseResp<Topic> createTopic(@RequestBody Topic topic) {

        Topic createTopic = topicService.createTopic(topic);

        BaseResp<Topic> mapPopBaseResp = new BaseResp<>();
        if (createTopic != null) {
            mapPopBaseResp.setData(createTopic);
            setErrorInfo(mapPopBaseResp, 0);
        } else {
            mapPopBaseResp.setData(createTopic);
            setErrorInfo(mapPopBaseResp, 1);
        }

        return mapPopBaseResp;
    }

    /**
     * —— 修改 coupon ——
     */
    @RequestMapping("topic/update")
    public BaseResp<Topic> updateTopic(@RequestBody Topic topic) {
        Topic updateTopic = topicService.updateTopic(topic);

        BaseResp<Topic> mapPopBaseResp = new BaseResp<>();
        if (updateTopic != null) {
            setErrorInfo(mapPopBaseResp, 0);
        } else {
            mapPopBaseResp.setData(updateTopic);
            setErrorInfo(mapPopBaseResp, 1);
        }

        return mapPopBaseResp;
    }

    /**
     * —— 删除 topic ——
     */
    @RequestMapping("topic/delete")
    public BaseResp<Topic> deleteTopic(@RequestBody Topic topic) {
        topic.setDeleted(true);
        Topic deleteTopic = topicService.updateTopic(topic);

        BaseResp<Topic> mapPopBaseResp = new BaseResp<>();
        if (deleteTopic != null) {
            setErrorInfo(mapPopBaseResp, 0);
        } else {
            setErrorInfo(mapPopBaseResp, 1);
        }

        return mapPopBaseResp;
    }

    /**
     * —— 显示详情 ——
     */
    @RequestMapping("topic/read")
    public BaseResp<Topic> readTopic(@RequestBody String id) {
        Topic readTopic = topicService.readTopicById(id);
        BaseResp<Topic> mapPopBaseResp = new BaseResp<>();
        if (readTopic != null) {
            mapPopBaseResp.setData(readTopic);
            setErrorInfo(mapPopBaseResp, 0);
        } else {
            setErrorInfo(mapPopBaseResp, 1);
        }

        return mapPopBaseResp;
    }

    /**
     * —— 添加成功、失败信息 ——
     */
    private void setErrorInfo(BaseResp popBaseResp, int isError) {
        if (isError == 0) {
            popBaseResp.setErrmsg("成功");
            popBaseResp.setErrno(0);
        } else {
            popBaseResp.setErrmsg("失败");
            popBaseResp.setErrno(1);
        }
    }
}
