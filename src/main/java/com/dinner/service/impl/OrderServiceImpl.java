package com.dinner.service.impl;

import com.dinner.dao.CuisineMapper;
import com.dinner.dao.FinanceMapper;
import com.dinner.dao.OrderMapper;
import com.dinner.model.Cuisine;
import com.dinner.model.Finance;
import com.dinner.model.Order;
import com.dinner.service.OrderService;
import com.dinner.util.ArithUtils;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
    @Resource
    private FinanceMapper financeMapper;
    @Resource
    private CuisineMapper cuisineMapper;

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

    @Override
    public boolean submit(List<Cuisine> orders, String phone) {
        Finance finance = new Finance();
        Double total = 0d;
        for (Cuisine cuisine : orders
        ) {
            if (cuisine.getNum() == 0) {
                continue;
            } else {
                Double price = cuisine.getPrice();
                Double num = (double) cuisine.getNum();
                Double temp = ArithUtils.mul(price, num);
                total = ArithUtils.add(total, temp);
            }

        }
        Calendar calendar = Calendar.getInstance();
        Long timestemp = calendar.getTimeInMillis();
        Date date = calendar.getTime();
        finance.setPrice(total);
        finance.setOrderId(timestemp);
        finance.setUserId(phone);
        finance.setDate(date);
        financeMapper.insert(finance);
        for (Cuisine cuisine : orders
        ) {
            if (cuisine.getNum() == 0) {
                continue;
            }
            Order order = new Order();
            order.setOrderId(timestemp);
            order.setUserId(phone);
            order.setName(cuisine.getLocation());
            order.setNum(cuisine.getNum());
            orderMapper.insert(order);
        }

        return true;
    }

    @Override
    public List<Order> selectByOrderIdAndUserId(Order order) {
        List<Order> list = orderMapper.selectByOrderIdAndUserId(order);
        for (Order order1 : list) {
            Cuisine cuisine = cuisineMapper.selectByPrimaryKey(order1.getName());
            order1.setPrice(cuisine.getPrice());
        }
        return list;
    }
}
