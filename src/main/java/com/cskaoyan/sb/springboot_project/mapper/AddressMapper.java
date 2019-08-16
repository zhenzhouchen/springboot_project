package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Address;
import com.cskaoyan.sb.springboot_project.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressMapper {
    List<Address> queryAllAddressList();

    List<Address> queryAddressList(@Param("name") String name,@Param("userId") Integer userId);

}