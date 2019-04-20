package com.dinner.controller;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * created on 2019-03-06
 *

 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springconfig.xml")
public class FinanceControllerTest {
    @Resource
    private FinanceController financeController;
    @Test
    public void filter() {
        System.out.println(financeController.filter(0,3,1));
    }
}
