package com.dinner.dao;

import com.dinner.model.Order;
import com.dinner.model.OrderKey;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {
    int deleteByPrimaryKey(OrderKey key);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(OrderKey key);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}
