package com.dinner.service;

import com.dinner.model.Finance;
import com.dinner.util.Pager;

import java.util.List;

/**
 * created on 2019-03-05
 *
 * @author dailinfu
 */


public interface FinanceService extends BaseService<Finance> {
    List<Finance> filterInDate(Pager<Finance> pager, Long timestemp, Long lastWeek);


}
