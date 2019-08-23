package com.cskaoyan.sb.springboot_project.controller.wxcontroller;

import com.cskaoyan.sb.springboot_project.bean.Address;
import com.cskaoyan.sb.springboot_project.bean.AddressInfo;
import com.cskaoyan.sb.springboot_project.bean.Address_receive;
import com.cskaoyan.sb.springboot_project.bean.Region;
import com.cskaoyan.sb.springboot_project.service.AddressService;
import com.cskaoyan.sb.springboot_project.service.RegionService;
import com.cskaoyan.sb.springboot_project.util.UserTokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
    @Autowired
    RegionService regionService;
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

    @RequestMapping("address/detail")
    public Map<String,Object> address_detail(int id){
        Map<String,Object> map = new HashMap<>();
        Address address = addressService.queryAddressInfoById(id);
        String areaName = addressService.queryNameById(address.getAreaId());
        String cityName = addressService.queryNameById(address.getCityId());
        String provinceName = addressService.queryNameById(address.getProvinceId());
        address.setAreaName(areaName);
        address.setCityName(cityName);
        address.setProvinceName(provinceName);
        map.put("data",address);
        map.put("errmsg","成功");
        map.put("errno",0);
        return map;
    }
    @RequestMapping("region/list")
    public Map<String,Object> region_list(int pid){
        Map<String,Object> map = new HashMap<>();
        List<Region> regionlist = regionService.queryRegion(pid);
        map.put("data",regionlist);
        map.put("errmsg","成功");
        map.put("errno",0);
        return map;
    }

    @RequestMapping("address/save")
    public Map<String,Object> address_save(@RequestBody AddressInfo addressInfo,HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        if(userId == null){
            return map;
        }
        addressInfo.setUserId(userId);
        int result =0;
        if(addressInfo.getId()==0){
            result = addressService.insertAddressInfo(addressInfo);
        }else {
            result = addressService.updateAddressInfo(addressInfo);
        }
        if(result==1) {
            map.put("errmsg", "成功");
        }
        map.put("errno",0);
        return map;
    }

    @RequestMapping("address/delete")
    public Map<String,Object> address_delete(@RequestBody AddressInfo addressInfo){
        Map<String,Object> map = new HashMap<>();
        int result = addressService.deleteAddress(addressInfo.getId());
        if(result==1)
            map.put("errmsg", "成功");
        map.put("errno",0);
        return map;
    }
}
