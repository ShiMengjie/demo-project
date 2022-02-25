package com.example.demo.data.statistic.domain.timefilter.entity;

import com.example.demo.data.statistic.domain.timefilter.entity.valueobject.TimeFilterEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 每日的时间过滤
 */
public class DayFilter implements TimeFilter {

    /**
     * 类型，也是唯一标识
     */
    private final TimeFilterEnum ID = TimeFilterEnum.DAY;

    @Override
    public TimeFilterEnum getID() {
        return this.ID;
    }

    @Override
    public LocalDateTime calNextDate(LocalDateTime curDate) {
        return curDate.plusDays(1);
    }

    @Override
    public LocalDateTime calLastDate(LocalDateTime curDate) {
        return curDate.minusDays(1);
    }

    /**
     * 结束时间，当天零点
     */
    @Override
    public LocalDateTime getEndDate() {
        return LocalDate.now().atStartOfDay();
    }

    @Override
    public LocalDateTime getBeginDate() {
        return LocalDate.now().minusDays(1).atStartOfDay();
    }

    /**
     * 每天都执行
     */
    @Override
    public boolean canDoStatistic() {
        return true;
    }
}
