package com.dinner.service;

import com.dinner.model.Login;
import com.dinner.util.Pager;

import java.util.List;

/**
 * created on 2019-03-03
 *

 */


public interface LoginService extends BaseService<Login> {
    List<Login> filter(Pager<Login> pager, Login login) throws Exception;
}
