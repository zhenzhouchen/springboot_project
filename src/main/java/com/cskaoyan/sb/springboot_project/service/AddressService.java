package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Address;



import java.util.List;


public interface AddressService {
    List<Address> queryAllAddressList();
    List<Address> queryAddressList(String name, Integer userId);

}
