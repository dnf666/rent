package com.dinner.dao;

import com.dinner.model.Finance;

public interface FinanceMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Finance record);

    int insertSelective(Finance record);

    Finance selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Finance record);

    int updateByPrimaryKey(Finance record);
}