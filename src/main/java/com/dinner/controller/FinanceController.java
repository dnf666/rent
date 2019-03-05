package com.dinner.controller;

import com.dinner.service.FinanceService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * created on 2019-03-05
 *
 * @author dailinfu
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("finance")
public class FinanceController {
    @Resource
    private FinanceService financeService;
}
