package com.dinner.service;

import com.dinner.model.Cost;
import com.dinner.util.Pager;

import java.util.List;

/**
 * created on 2019-03-12
 *
 * @author dailinfu
 */


public interface CostService extends BaseService<Cost>{
    List<Cost> filter(Pager<Cost> pager, Long timestemp, Long lastWeek) throws Exception;
}
