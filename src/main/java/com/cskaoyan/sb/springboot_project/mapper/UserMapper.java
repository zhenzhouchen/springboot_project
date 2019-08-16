package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> queryAllUserList();
    List<User> queryUserList(@Param("username") String username, @Param("mobile") String mobile);











    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}