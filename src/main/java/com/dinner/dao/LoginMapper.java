package com.dinner.dao;

import com.dinner.model.Login;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginMapper {
    int deleteByPrimaryKey(String phone);

    int insert(Login record);

    int insertSelective(Login record);

    Login selectByPrimaryKey(String phone);

    int updateByPrimaryKeySelective(Login record);

    int updateByPrimaryKey(Login record);
}