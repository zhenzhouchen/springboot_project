package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Collect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectMapper {
    List<Collect> queryAllCollectList();
    List<Collect> queryCollectList(@Param("userId") Integer userId, @Param("valueId") Integer valueId);



    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);
}