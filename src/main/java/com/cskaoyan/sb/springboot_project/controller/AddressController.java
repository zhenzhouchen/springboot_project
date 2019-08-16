package com.cskaoyan.sb.springboot_project.controller;

import com.cskaoyan.sb.springboot_project.bean.Address;
import com.cskaoyan.sb.springboot_project.bean.User;
import com.cskaoyan.sb.springboot_project.service.AddressService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AddressController {
    @Autowired
    AddressService addressService;

    //地址管理列表
    @RequestMapping("/address/list")
    @ResponseBody
    public Map<String,Object> query_address_list(int page,int limit,String name,Integer userId,String sort,String order){
        //开启分页
        PageHelper.startPage(page,limit);
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> info_map = new HashMap<>();
        List<Address> items =null;
        if(name == null && userId ==null){
            items = addressService.queryAllAddressList(sort,order);

        }else{
            items = addressService.queryAddressList(name,userId,sort,order);
        }
        //获取每页的总记录数
        PageInfo<Address> userPageInfo = new PageInfo<>(items);info_map.put("items",items);
        long total = userPageInfo.getTotal();

        info_map.put("total",total);
        info_map.put("items",items);
        map.put("errmsg","成功");
        map.put("errno",0);
        map.put("data",info_map);
        return map;
    }
}
