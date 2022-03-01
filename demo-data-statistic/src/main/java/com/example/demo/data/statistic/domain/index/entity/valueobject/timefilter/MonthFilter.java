package com.example.demo.data.statistic.domain.index.entity.valueobject.timefilter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;

/**
 * 每月的时间过滤
 */
public class MonthFilter implements TimeFilter {

    private final TimeFilterEnum TYPE = TimeFilterEnum.MONTH;

    @Override
    public TimeFilterEnum getTYPE() {
        return this.TYPE;
    }

    @Override
    public LocalDateTime calNextDate(LocalDateTime curDate) {
        return curDate.plusMonths(1);
    }

    /**
     * 结束时间，当月1号零点
     */
    @Override
    public LocalDateTime getEndDate() {
        return YearMonth.now().atDay(1).atStartOfDay();
    }

    /**
     * 开始时间，前一个月 1号0点
     */
    @Override
    public LocalDateTime getBeginDate() {
        return LocalDate.now().minusMonths(1).withDayOfMonth(1).atStartOfDay();
    }

    /**
     * 每月1号，执行统计
     */
    @Override
    public boolean canDoStatistic() {
        return LocalDate.now().getDayOfMonth() == 1;
    }

}
