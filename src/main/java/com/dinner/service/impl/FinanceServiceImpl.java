package com.dinner.service.impl;

import com.dinner.dao.FinanceMapper;
import com.dinner.dao.LoginMapper;
import com.dinner.model.Finance;
import com.dinner.model.Login;
import com.dinner.service.FinanceService;
import com.dinner.util.Pager;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
    @Resource
    private LoginMapper loginMapper;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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

    @Override
    public List<Finance> filterInDate(Pager<Finance> pager, Long timestemp, Long lastWeek) {
        Date endTime = new Date(timestemp);
        Date startTime = new Date(lastWeek);
        simpleDateFormat.format(startTime);
        simpleDateFormat.format(endTime);
        int total = financeMapper.countByDateDesc(endTime,startTime);
        pager.setRecordSize(total);
        List<Finance> list =  financeMapper.selectByDateDesc(pager,endTime,startTime);
        for (Finance finance : list){
            Integer phone = finance.getUserId();
            Login login = loginMapper.selectByPrimaryKey(phone.toString());
            finance.setName(login.getName());
        }
        return list;
    }


}
