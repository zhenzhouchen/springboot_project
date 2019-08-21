package com.cskaoyan.sb.springboot_project.controller.wxcontroller;

import com.cskaoyan.sb.springboot_project.bean.Address_receive;
import com.cskaoyan.sb.springboot_project.service.AddressService;
import com.cskaoyan.sb.springboot_project.util.UserTokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wx")
public class UtilsController {
    @Autowired
    AddressService addressService;
    @RequestMapping("address/list")
    public Map<String,Object> address_list(HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        if(userId == null){
            return map;
        }
        List<Address_receive> address_receiveList = addressService.queryAddressReceById(userId);
        map.put("data",address_receiveList);
        map.put("errmsg","成功");
        map.put("errno",0);
        return map;
    }
}
