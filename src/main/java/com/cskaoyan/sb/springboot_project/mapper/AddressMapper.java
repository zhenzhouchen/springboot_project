package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Address;

public interface AddressMapper {
    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}