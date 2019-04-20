package com.dinner.service.impl;

import com.dinner.dao.LoginMapper;
import com.dinner.model.Login;
import com.dinner.service.LoginService;
import com.dinner.util.Pager;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.annotation.Resource;

/**
 * created on 2019-03-03
 *

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
    public Login selectByPrimaryKey(Login key) throws Exception {
        String phone = key.getPhone();
        String password = key.getPassword();
        Login login1 = loginMapper.selectByPrimaryKey(phone);
        if (login1 == null) {
            throw new Exception("不存在该用户");
        }
        if (!login1.getPassword().equals(password)) {
            throw new Exception("密码错误");
        }
        return login1;
    }

    @Override
    public int updateByPrimaryKey(Login record) {
        return 0;
    }

    @Override
    public List<Login> filter(Pager<Login> pager, Login login) throws Exception {
        Integer total = loginMapper.countloginsByKeys(login);
        pager.setRecordSize(total);
        if (total != 0) {
            return loginMapper.filter(pager, login);
        } else {
            throw new Exception("数据为空");
        }
    }
}
