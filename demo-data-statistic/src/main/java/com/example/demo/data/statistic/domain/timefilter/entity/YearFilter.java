package com.example.demo.data.statistic.domain.timefilter.entity;

import com.example.demo.data.statistic.domain.timefilter.entity.valueobject.TimeFilterEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 每年的时间过滤
 */
public class YearFilter implements TimeFilter {

    /**
     * 类型，也是唯一标识
     */
    private final TimeFilterEnum ID = TimeFilterEnum.YEAR;

    @Override
    public TimeFilterEnum getID() {
        return this.ID;
    }

    @Override
    public LocalDateTime calNextDate(LocalDateTime curDate) {
        return curDate.plusYears(1);
    }

    @Override
    public LocalDateTime calLastDate(LocalDateTime curDate) {
        return curDate.minusYears(1);
    }

    /**
     * 结束时间，今年1月1日
     */
    @Override
    public LocalDateTime calEndDate() {
        return LocalDate.now().withDayOfYear(1).atStartOfDay();
    }

    /**
     * 每年1月1号，执行统计
     */
    @Override
    public boolean canDoStatistic() {
        return LocalDate.now().getDayOfYear() == 1;
    }
}
