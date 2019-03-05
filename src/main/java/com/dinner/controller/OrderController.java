package com.dinner.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * created on 2019-03-05
 *
 * @author dailinfu
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("order")
public class OrderController {
}
