package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Search_history;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Search_historyMapper {
    List<Search_history> queryAllHistoryList(@Param("sort") String sort,@Param("order") String order);
    List<Search_history> queryHistoryList(@Param("userId") Integer userId, @Param("keyword") String keyword,@Param("sort") String sort,@Param("order") String order);

    int updateByPrimaryKeySelective(Search_history record);

    int updateByPrimaryKey(Search_history record);

    List<Search_history> historyKeywordList();

    List<String> searchHelper(String keyword);

    int selectByKeyword(@Param("userId") Integer userId, @Param("keyword") String keyword);

    int insertSearchHistory(@Param("userId") Integer userId, @Param("keyword") String keyword);

    int updateDeletedByUserId(Integer userId);
}