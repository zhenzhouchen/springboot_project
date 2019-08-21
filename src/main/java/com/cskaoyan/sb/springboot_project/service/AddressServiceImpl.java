package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Address;
import com.cskaoyan.sb.springboot_project.bean.Address_receive;
import com.cskaoyan.sb.springboot_project.bean.User;
import com.cskaoyan.sb.springboot_project.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressMapper addressMapper;

    @Override
    public List<Address> queryAllAddressList(String sort,String order) {
        return addressMapper.queryAllAddressList(sort,order);
    }

    @Override
    public List<Address> queryAddressList(String name, Integer userId,String sort,String order) {
        return addressMapper.queryAddressList(name, userId,sort,order);
    }

    @Override
    public List<Address_receive> queryAddressReceById(int userId) {
        return addressMapper.queryAddressReceById(userId);
    }
}
