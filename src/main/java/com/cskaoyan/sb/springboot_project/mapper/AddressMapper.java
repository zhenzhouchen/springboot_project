package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Address;
import com.cskaoyan.sb.springboot_project.bean.AddressInfo;
import com.cskaoyan.sb.springboot_project.bean.Address_receive;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AddressMapper {
    List<Address> queryAllAddressList(@Param("sort") String sort,@Param("order") String order);

    List<Address> queryAddressList(@Param("name") String name,@Param("userId") Integer userId,@Param("sort") String sort,@Param("order") String order);

    List<Address_receive> queryAddressReceById(@Param("userId") int userId);

    Address queryDefaultAddress(Integer userId);

    Address queryAddressReceByAddressId(int addressId);
    Address queryAddressInfoById(@Param("id") int id);

    @Select("select name from cskaoyan_mall_region where id = #{id}")
    String queryNameById(@Param("id") Integer id);

    int updateAddressInfo(@Param("addressInfo") AddressInfo addressInfo);

    int insertAddressInfo(@Param("addressInfo") AddressInfo addressInfo);
    @Delete("delete from cskaoyan_mall_address where id = #{id}")
    int deleteAddress(@Param("id") int id);

}