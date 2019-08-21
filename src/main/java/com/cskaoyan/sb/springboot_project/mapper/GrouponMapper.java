package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Groupon;
import com.cskaoyan.sb.springboot_project.bean.GrouponExample;
import java.util.List;

import com.cskaoyan.sb.springboot_project.bean.Groupon;
import com.cskaoyan.sb.springboot_project.bean.Popularize.GrouponDetail;
import org.apache.ibatis.annotations.Param;

public interface GrouponMapper {
    long countByExample(GrouponExample example);

    int deleteByExample(GrouponExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Groupon record);

    int insertSelective(Groupon record);

    List<Groupon> selectByExample(GrouponExample example);

    Groupon selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Groupon record, @Param("example") GrouponExample example);

    int updateByExample(@Param("record") Groupon record, @Param("example") GrouponExample example);

    int updateByPrimaryKeySelective(Groupon record);

    int updateByPrimaryKey(Groupon record);

    List<Groupon> listGrouponByCondition(@Param("sort") String sort, @Param("order") String order);

    List<Groupon> searchGrouponByCondition(@Param("sort") String sort, @Param("order") String order, @Param("goodsId") String goodsId);

    List<Groupon> listGrouponByRulesId(@Param("rulesIds") List<Integer> rulesIds);
}