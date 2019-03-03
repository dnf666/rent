package com.dinner.service.impl;

import com.dinner.dao.LoginMapper;
import com.dinner.model.Login;
import com.dinner.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * created on 2019-03-03
 *
 * @author dailinfu
 */

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private LoginMapper loginMapper;
    @Override
    public int deleteByPrimaryKey(Login key) {
        return 0;
    }

    @Override
    public int insert(Login record) {
        return loginMapper.insert(record);
    }

    @Override
    public Login selectByPrimaryKey(Login key) {
        return null;
    }

    @Override
    public int updateByPrimaryKey(Login record) {
        return 0;
    }
}
