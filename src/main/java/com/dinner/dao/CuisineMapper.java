package com.dinner.dao;

import com.dinner.model.Cuisine;

public interface CuisineMapper {
    int deleteByPrimaryKey(String name);

    int insert(Cuisine record);

    int insertSelective(Cuisine record);

    Cuisine selectByPrimaryKey(String name);

    int updateByPrimaryKeySelective(Cuisine record);

    int updateByPrimaryKey(Cuisine record);
}