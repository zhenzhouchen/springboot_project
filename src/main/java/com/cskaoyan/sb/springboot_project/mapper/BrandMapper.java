package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface BrandMapper {
    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);

    List<Brand> selectBrandList(int page, int limit, @Param("id") Integer id, @Param("name") String name, @Param("sort") String sort, @Param("order") String order);

    List<Brand> brandList();

    int insertBrand(Brand brand);

    @Update("update cskaoyan_mall_brand set deleted = 1 where id = #{id}")
    int deleteBrandById(Brand brand);

    int updateBrandById(Brand brand);

    Brand queryBrandByBrandId(@Param("brandId") Integer brandId);
}