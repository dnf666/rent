package com.dinner.service.impl;

import com.dinner.dao.OrderMapper;
import com.dinner.model.Order;
import com.dinner.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * created on 2019-03-05
 *
 * @author dailinfu
 */

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Override
    public int deleteByPrimaryKey(Order key) {
        return 0;
    }

    @Override
    public int insert(Order record) {
        return 0;
    }

    @Override
    public Order selectByPrimaryKey(Order key) throws Exception {
        return null;
    }

    @Override
    public int updateByPrimaryKey(Order record) {
        return 0;
    }
}
