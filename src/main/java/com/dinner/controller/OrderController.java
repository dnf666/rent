package com.dinner.controller;

import com.dinner.model.Cuisine;
import com.dinner.model.Order;
import com.dinner.service.OrderService;
import com.dinner.util.ResponseEntity;
import com.google.common.base.Strings;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import javax.annotation.Resource;

/**
 * created on 2019-03-05
 *
 * @author dailinfu
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("order")
public class OrderController {
    @Resource
    private OrderService orderService;

    @PostMapping("submit")
    public ResponseEntity submit(@RequestBody List<Cuisine> orders, String phone) {
        boolean result = false;
        if (Strings.isNullOrEmpty(phone)) {
            return new ResponseEntity(0, "phone is null", "");
        }
        if (orders == null || orders.size() == 0) {
            return new ResponseEntity(0, "order is null", "");
        }
        try {
            result = orderService.submit(orders, phone);
            return new ResponseEntity(1, "订餐成功", result);
        } catch (Exception e) {
            return new ResponseEntity(0, e.getMessage(), result);
        }
    }

    @GetMapping("order")
    public ResponseEntity getDetail(Long orderId, String userId) {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setUserId(userId);
        try {
            List<Order> list = orderService.selectByOrderIdAndUserId(order);
            return new ResponseEntity(1, "find success", list);
        } catch (Exception e) {
            return new ResponseEntity(0, e.getMessage(), null);
        }
    }
}
