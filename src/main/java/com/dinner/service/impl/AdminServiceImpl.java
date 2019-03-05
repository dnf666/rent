package com.dinner.service.impl;

import com.dinner.dao.AdminMapper;
import com.dinner.model.Admin;
import com.dinner.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * created on 2019-03-03
 *
 * @author dailinfu
 */

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;
    @Override
    public int deleteByPrimaryKey(Admin key) {
        return 0;
    }

    @Override
    public int insert(Admin record) {
        return 0;
    }

    @Override
    public Admin selectByPrimaryKey(Admin key) throws Exception {
        String id = key.getId();
        String password = key.getPassword();
        Admin login1 = adminMapper.selectByPrimaryKey(id);
        if (login1 == null) {
            throw new Exception("不存在该用户");
        }
        if(!login1.getPassword().equals(password)){
            throw new Exception("密码错误");
        }
        return login1;
    }

    @Override
    public int updateByPrimaryKey(Admin record) {
        return 0;
    }
}
