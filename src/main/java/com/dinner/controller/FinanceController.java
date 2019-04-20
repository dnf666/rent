package com.dinner.controller;

import com.dinner.model.Finance;
import com.dinner.service.FinanceService;
import com.dinner.util.Pager;
import com.dinner.util.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

/**
 * created on 2019-03-05
 *
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("finance")
public class FinanceController {
    @Resource
    private FinanceService financeService;

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
                int dayofweek = calendar.get(Calendar.DAY_OF_WEEK);
                if (dayofweek == 1) {
                    dayofweek += 7;
                }
                calendar.add(Calendar.DATE, 2 - dayofweek);
                long currentWeekStart = getDayStartTime(calendar.getTime());
                list = financeService.filterInDate(pager, timestemp, currentWeekStart);
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

    private Long getDayStartTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if (null != d) {
            calendar.setTime(d);
        }
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }
}
