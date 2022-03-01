package com.example.demo.data.statistic.domain.index.entity.valueobject.timefilter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 每周的时间过滤
 */
public class WeekFilter implements TimeFilter {

    private final TimeFilterEnum TYPE = TimeFilterEnum.WEEK;

    @Override
    public TimeFilterEnum getTYPE() {
        return this.TYPE;
    }

    @Override
    public LocalDateTime calNextDate(LocalDateTime curDate) {
        return curDate.plusWeeks(1);
    }

    /**
     * 结束时间，本周一
     */
    @Override
    public LocalDateTime getEndDate() {
        return LocalDate.now().with(DayOfWeek.MONDAY).atStartOfDay();
    }

    /**
     * 开始时间，上周周一0点
     */
    @Override
    public LocalDateTime getBeginDate() {
        return LocalDate.now().minusWeeks(1).with(DayOfWeek.MONDAY).atStartOfDay();
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
