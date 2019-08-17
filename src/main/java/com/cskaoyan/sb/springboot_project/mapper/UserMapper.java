package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface UserMapper {
    List<User> queryAllUserList(@Param("sort") String sort,@Param("order")String order);
    List<User> queryUserList(@Param("username") String username, @Param("mobile") String mobile,@Param("sort") String sort,@Param("order")String order);

    User selectUserDetailForOrderByUserId(@Param("userId") Integer userId);

    @Select("select last_login_time from cskaoyan_mall_user  limit 1")
    Date query_user_statistics_day();
    @Select("select count(id) from cskaoyan_mall_user")
    int query_user_statistics_users();




    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


}