package com.dinner.controller;

import com.dinner.model.Finance;
import com.dinner.service.FinanceService;
import com.dinner.util.Pager;
import com.dinner.util.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.List;
import javax.annotation.Resource;

/**
 * created on 2019-03-05
 *
 * @author dailinfu
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("finance")
public class FinanceController {
    @Resource
    private FinanceService financeService;
    private static final long ONE_WEEK = 60 * 1000 * 60 * 24 * 7;

    @PostMapping("filter")
    public ResponseEntity filter(int page, int size, int sign) {
        Calendar calendar = Calendar.getInstance();
        Long timestemp = calendar.getTimeInMillis();
        Pager<Finance> pager = new Pager<>();
        pager.setCurrentPage(page);
        pager.setPageSize(size);
        List<Finance> list = null;
        try {
            if (sign == 0) {
                list = financeService.filterInDate(pager, timestemp, 1483200000000L);
            } else if (sign == 1) {
                list = financeService.filterInDate(pager, timestemp, timestemp - ONE_WEEK);
            } else if (sign == 2) {
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);
                calendar.set(year, month, 1, 0, 0, 0);
                long firstDayMonth = calendar.getTimeInMillis();
                list = financeService.filterInDate(pager, timestemp, firstDayMonth);
            } else if (sign == 3) {
                int year = calendar.get(Calendar.YEAR);
                calendar.set(year, 0, 1, 0, 0, 0);
                long currentYear = calendar.getTimeInMillis();
                list = financeService.filterInDate(pager, timestemp, currentYear);
            } else {
                return new ResponseEntity(0, "不识别的signal", pager);
            }
        } catch (Exception e) {
            return new ResponseEntity(0, e.getMessage(), pager);
        }
        pager.setData(list);
        return new ResponseEntity(1, "find finance success", pager);
    }


}
