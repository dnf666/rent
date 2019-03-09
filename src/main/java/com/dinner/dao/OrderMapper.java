package com.dinner.dao;

import com.dinner.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    int deleteByPrimaryKey(Order key);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Order key);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> selectByOrderIdAndUserId(Order order);
}
