package com.dinner.service;

import com.dinner.model.Cuisine;
import com.dinner.model.Order;

import java.util.List;

/**
 * created on 2019-03-05
 *

 */


public interface OrderService extends BaseService<Order>{
    boolean submit(Cuisine orders, String phone);

    List<Order> selectByOrderIdAndUserId(Order order);
}
