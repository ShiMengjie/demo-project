package com.example.demo.data.statistic.domain.timefilter.entity;

import com.example.demo.data.statistic.domain.timefilter.entity.valueobject.TimeFilterEnum;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 每周的时间过滤
 */
public class WeekFilter implements TimeFilter {

    /**
     * 类型，也是唯一标识
     */
    private final TimeFilterEnum ID = TimeFilterEnum.WEEK;

    @Override
    public TimeFilterEnum getID() {
        return this.ID;
    }

    @Override
    public LocalDateTime calNextDate(LocalDateTime curDate) {
        return curDate.plusWeeks(1);
    }

    @Override
    public LocalDateTime calLastDate(LocalDateTime curDate) {
        return curDate.minusWeeks(1);
    }

    /**
     * 结束时间，本周一
     */
    @Override
    public LocalDateTime calEndDate() {
        return LocalDate.now().with(DayOfWeek.MONDAY).atStartOfDay();
    }

    /**
     * 每周一执行统计
     *
     * @return
     */
    @Override
    public boolean canDoStatistic() {
        return LocalDate.now().getDayOfWeek().equals(DayOfWeek.MONDAY);
    }
}
