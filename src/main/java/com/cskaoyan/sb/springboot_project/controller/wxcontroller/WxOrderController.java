package com.cskaoyan.sb.springboot_project.controller.wxcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/wx")
public class WxOrderController {

    @RequestMapping("order/list")
    public Map<String,Object> order_list(Integer showType, int page,int size){
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> intermap = new HashMap<>();
        if(showType ==null || showType ==0){

        }else if(showType ==2){

        }else if(showType ==3){

        }else{

        }
        map.put("errmsg","成功");
        map.put("errno",0);
        return map;
    }
}
