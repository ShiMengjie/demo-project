package com.example.demo.data.statistic.domain.timefilter.entity;

import com.example.demo.data.statistic.domain.timefilter.entity.valueobject.TimeFilterEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;

/**
 * 每月的时间过滤
 */
public class MonthFilter implements TimeFilter {

    /**
     * 类型，也是唯一标识
     */
    private final TimeFilterEnum ID = TimeFilterEnum.MONTH;

    @Override
    public TimeFilterEnum getID() {
        return this.ID;
    }

    @Override
    public LocalDateTime calNextDate(LocalDateTime curDate) {
        return curDate.plusMonths(1);
    }

    @Override
    public LocalDateTime calLastDate(LocalDateTime curDate) {
        return curDate.minusMonths(1);
    }

    /**
     * 结束时间，当月1号零点
     */
    @Override
    public LocalDateTime calEndDate() {
        return YearMonth.now().atDay(1).atStartOfDay();
    }

    /**
     * 每月1号，执行统计
     */
    @Override
    public boolean canDoStatistic() {
        return LocalDate.now().getDayOfMonth() == 1;
    }

}
