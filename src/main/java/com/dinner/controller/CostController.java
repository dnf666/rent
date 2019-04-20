package com.dinner.controller;

import com.dinner.model.Cost;
import com.dinner.service.CostService;
import com.dinner.util.Pager;
import com.dinner.util.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

/**
 * created on 2019-03-12
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("cost")
public class CostController {

    @Resource
    private CostService costService;

    @PostMapping("cost")
    public ResponseEntity add(@RequestBody Cost cost) {
        int result = 0;
        if (cost == null) {
            return new ResponseEntity(0, "cost is null", "");
        }
        try {
            result = costService.insert(cost);
            return new ResponseEntity(1, "添加成功", result);
        } catch (Exception e) {
            return new ResponseEntity(0, e.getMessage(), result);
        }
    }

    @PutMapping("cost")
    public ResponseEntity updateCost(@RequestBody Cost cost) {
        int result = costService.updateByPrimaryKey(cost);
        return new ResponseEntity<>(1, "更改成功", result);

    }

    @PostMapping("delCost")
    public ResponseEntity deleteCostInfoByCostName(@RequestBody Cost cost) {
        if (cost.getId() == null) {
            return new ResponseEntity<>(0, "说明为空", "");
        }
        int result = costService.deleteByPrimaryKey(cost);
        return new ResponseEntity<>(1, "删除成功", result);
    }

    @PostMapping("filter")
    public ResponseEntity filter(int page, int size, int sign) {
        Calendar calendar = Calendar.getInstance();
        Long timestemp = calendar.getTimeInMillis();
        Pager<Cost> pager = new Pager<>();
        pager.setCurrentPage(page);
        pager.setPageSize(size);
        List<Cost> list = null;
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        try {
            if (sign == 0) {
                list = costService.filter(pager, timestemp, 1483200000000L);
            } else if (sign == 1) {
                int dayofweek = calendar.get(Calendar.DAY_OF_WEEK);
                if (dayofweek == 1) {
                    dayofweek += 7;
                }
                calendar.add(Calendar.DATE, 2 - dayofweek);
                long currentWeekStart = getDayStartTime(calendar.getTime());
                list = costService.filter(pager, timestemp, currentWeekStart);
            } else if (sign == 2) {
                calendar.set(year, month, 1, 0, 0, 0);
                long firstDayMonth = calendar.getTimeInMillis();
                list = costService.filter(pager, timestemp, firstDayMonth);
            } else if (sign == 3) {
                calendar.set(year, 0, 1, 0, 0, 0);
                long currentYear = calendar.getTimeInMillis();
                list = costService.filter(pager, timestemp, currentYear);
            } else {
                return new ResponseEntity(0, "不识别的signal", pager);
            }
        } catch (Exception e) {
            return new ResponseEntity(0, e.getMessage(), pager);
        }
        pager.setData(list);
        return new ResponseEntity(1, "find cost success", pager);
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

