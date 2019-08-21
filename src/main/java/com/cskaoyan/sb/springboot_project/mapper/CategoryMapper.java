package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Category;
import com.cskaoyan.sb.springboot_project.bean.CategoryList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CategoryMapper {
    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    List<Category> selectCategoryList();

    List<Category> selectLevel1List();

    List<CategoryList> CategoryListlevel1();

    int insertCategory(Category category);

    int updateCategoryById(Category category);

    @Update("update cskaoyan_mall_category set deleted = 1 where id = #{id}")
    int deleteCategoryById(Category category);

    @Select("select id,name from cskaoyan_mall_category where level = 'L1' and deleted = 0")
    List<Category> queryIdForfloorGoodsList();

    @Select("select id from cskaoyan_mall_category where pid = #{id} and deleted = 0")
    List<Integer> queryId2ForfloorGoodsList(Integer id);

    Integer queryCategoryIds(Integer id);

    List<Category> channel();
}