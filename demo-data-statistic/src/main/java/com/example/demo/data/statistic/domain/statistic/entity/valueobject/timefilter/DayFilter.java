package com.example.demo.data.statistic.domain.statistic.entity.valueobject.timefilter;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 每日的时间过滤
 */
public class DayFilter implements TimeFilter {

    private final TimeFilterEnum TYPE = TimeFilterEnum.DAY;

    @Override
    public TimeFilterEnum getTYPE() {
        return this.TYPE;
    }

    @Override
    public LocalDateTime calNextDate(LocalDateTime curDate) {
        return curDate.plusDays(1);
    }

    /**
     * 结束时间，当天零点
     */
    @Override
    public LocalDateTime getEndDate() {
        return LocalDate.now().atStartOfDay();
    }

    /**
     * 开始时间，前一天0点
     */
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
