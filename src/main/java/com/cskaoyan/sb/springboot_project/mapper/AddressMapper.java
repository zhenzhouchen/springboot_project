package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Address;
import com.cskaoyan.sb.springboot_project.bean.Address_receive;
import com.cskaoyan.sb.springboot_project.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AddressMapper {
    List<Address> queryAllAddressList(@Param("sort") String sort,@Param("order") String order);

    List<Address> queryAddressList(@Param("name") String name,@Param("userId") Integer userId,@Param("sort") String sort,@Param("order") String order);

    List<Address_receive> queryAddressReceById(@Param("userId") int userId);

    Address queryDefaultAddress(Integer userId);

    Address queryAddressReceByAddressId(int addressId);
}