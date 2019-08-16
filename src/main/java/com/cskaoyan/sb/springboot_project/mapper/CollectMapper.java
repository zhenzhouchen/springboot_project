package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Collect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectMapper {
    List<Collect> queryAllCollectList(@Param("sort") String sort,@Param("order") String order);
    List<Collect> queryCollectList(@Param("userId") Integer userId, @Param("valueId") Integer valueId,@Param("sort") String sort,@Param("order") String order);



    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);
}