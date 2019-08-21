package com.cskaoyan.sb.springboot_project.controller.wxcontroller;

import com.cskaoyan.sb.springboot_project.service.WxHomeIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wx")
public class WxHomeIndexController {
    @Autowired
    WxHomeIndexService wxIndexService;

    @RequestMapping("/home/index")
    public Map<String, Object> homeIndex() {
        Map<String, Object> map = new HashMap<>();
        Map<String,Object> data = wxIndexService.queryAllIndexList();
        map.put("data", data);
        map.put("errmsg", "成功");
        map.put("errno", 0);
        return map;
    }

    @RequestMapping("/goods/count")
    public Map<String, Object> goodsCount() {
        Map<String, Object> map = new HashMap<>();
        Map<String,Object> data=new HashMap<>();
        List<Integer> goodsCount = wxIndexService.goodsCount();
        data.put("goodsCount",goodsCount);
        map.put("data", data);
        map.put("errmsg", "成功");
        map.put("errno", 0);
        return map;
    }

}
