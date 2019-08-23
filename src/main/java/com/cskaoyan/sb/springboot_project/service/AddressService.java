package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Address;
import com.cskaoyan.sb.springboot_project.bean.AddressInfo;
import com.cskaoyan.sb.springboot_project.bean.Address_receive;


import java.util.List;


public interface AddressService {
    List<Address> queryAllAddressList(String sort,String order);
    List<Address> queryAddressList(String name, Integer userId,String sort,String order);


    List<Address_receive> queryAddressReceById(int userId);
    Address queryAddressInfoById(int id);


    String queryNameById(Integer id);

    int updateAddressInfo(AddressInfo addressInfo);

    int insertAddressInfo(AddressInfo addressInfo);
}
