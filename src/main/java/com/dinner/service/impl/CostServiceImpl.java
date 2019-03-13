package com.dinner.service.impl;

import com.dinner.dao.CostMapper;
import com.dinner.model.Cost;
import com.dinner.service.CostService;
import com.dinner.util.ArithUtils;
import com.dinner.util.Pager;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

/**
 * created on 2019-03-12
 *
 * @author dailinfu
 */

@Service
public class CostServiceImpl implements CostService {
    @Resource
    private CostMapper costMapper;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public int deleteByPrimaryKey(Cost key) {
        return costMapper.deleteByPrimaryKey(key.getId());
    }

    @Override
    public int insert(Cost record) {
        return costMapper.insert(record);
    }

    @Override
    public Cost selectByPrimaryKey(Cost key) throws Exception {
        return null;
    }

    @Override
    public int updateByPrimaryKey(Cost record) {
        return costMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Cost> filter(Pager<Cost> pager, Long timestemp, Long lastWeek) throws Exception {
        Date endTime = new Date(timestemp);
        Date startTime = new Date(lastWeek);
        simpleDateFormat.format(startTime);
        simpleDateFormat.format(endTime);
        List<Cost> list =  costMapper.selectByDateDesc(pager,endTime,startTime);
        double total = 0d;
        for (Cost cost : list){
            total = ArithUtils.add(total,cost.getPrice());
        }
        pager.setTotal(total);
        return list;
    }
}
