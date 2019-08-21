package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.User;
import com.cskaoyan.sb.springboot_project.bean.UserInfo;
import com.cskaoyan.sb.springboot_project.bean.User_statistics;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface UserMapper {
    List<User> queryAllUserList(@Param("sort") String sort,@Param("order")String order);
    List<User> queryUserList(@Param("username") String username, @Param("mobile") String mobile,@Param("sort") String sort,@Param("order")String order);

    User selectUserDetailForOrderByUserId(@Param("userId") Integer userId);

    List<User_statistics> query_user_statistics_bean();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Select("select password from cskaoyan_mall_user where username = #{username}")
    String queryPasswordByName(@Param("username") String username);

    UserInfo query_UserInfoByUsername(@Param("username") String username);
}