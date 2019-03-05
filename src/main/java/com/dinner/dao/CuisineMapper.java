package com.dinner.dao;

import com.dinner.model.Cuisine;
import com.dinner.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CuisineMapper {
    int deleteByPrimaryKey(String name);

    int insert(Cuisine record);

    int insertSelective(Cuisine record);

    Cuisine selectByPrimaryKey(String name);

    int updateByPrimaryKeySelective(Cuisine record);

    int updateByPrimaryKey(Cuisine record);

    Integer countCuisinesByKeys(Cuisine cuisine);

    List<Cuisine> filter(@Param("pager") Pager<Cuisine> pager, @Param("cuisine") Cuisine cuisine);
}
