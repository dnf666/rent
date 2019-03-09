package com.dinner.service;

import com.dinner.model.Cuisine;
import com.dinner.model.Order;

import java.util.List;

/**
 * created on 2019-03-05
 *
 * @author dailinfu
 */


public interface OrderService extends BaseService<Order>{
    boolean submit(List<Cuisine> orders, String phone);

    List<Order> selectByOrderIdAndUserId(Order order);
}
