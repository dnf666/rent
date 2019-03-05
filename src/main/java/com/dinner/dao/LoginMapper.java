package com.dinner.dao;

import com.dinner.model.Login;
import com.dinner.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginMapper {
    int deleteByPrimaryKey(String phone);

    int insert(Login record);

    int insertSelective(Login record);

    Login selectByPrimaryKey(String phone);

    int updateByPrimaryKeySelective(Login record);

    int updateByPrimaryKey(Login record);

    Integer countloginsByKeys(Login login);

    List<Login> filter(@Param("pager") Pager<Login> pager, @Param("login") Login login);
}
