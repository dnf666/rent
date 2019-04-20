package com.dinner.service;

import com.dinner.model.Finance;
import com.dinner.model.Order;

import java.util.List;

/**
 * created on 2019-03-05
 *

 */


public interface OrderService extends BaseService<Order>{
    boolean submit(Finance orders, String phone);

    List<Order> selectByOrderIdAndUserId(Order order);
}
