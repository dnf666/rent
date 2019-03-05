package com.dinner.service.impl;

import com.dinner.dao.FinanceMapper;
import com.dinner.model.Finance;
import com.dinner.service.FinanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * created on 2019-03-05
 *
 * @author dailinfu
 */

@Service
public class FinanceServiceImpl implements FinanceService {
    @Resource
    private FinanceMapper financeMapper;
    @Override
    public int deleteByPrimaryKey(Finance key) {
        return 0;
    }

    @Override
    public int insert(Finance record) {
        return 0;
    }

    @Override
    public Finance selectByPrimaryKey(Finance key) throws Exception {
        return null;
    }

    @Override
    public int updateByPrimaryKey(Finance record) {
        return 0;
    }
}
