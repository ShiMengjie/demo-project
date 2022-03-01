package com.example.demo.data.statistic.domain.index.entity.valueobject.timefilter;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 每年的时间过滤
 */
public class YearFilter implements TimeFilter {

    private final TimeFilterEnum TYPE = TimeFilterEnum.YEAR;

    @Override
    public TimeFilterEnum getTYPE() {
        return this.TYPE;
    }

    @Override
    public LocalDateTime calNextDate(LocalDateTime curDate) {
        return curDate.plusYears(1);
    }

    /**
     * 结束时间，今年1月1日
     */
    @Override
    public LocalDateTime getEndDate() {
        return LocalDate.now().withDayOfYear(1).atStartOfDay();
    }

    /**
     * 开始时间，前一年第一天0点
     */
    @Override
    public LocalDateTime getBeginDate() {
        return LocalDate.now().minusYears(1).withDayOfYear(1).atStartOfDay();
    }

    /**
     * 每年1月1号，执行统计
     */
    @Override
    public boolean canDoStatistic() {
        return LocalDate.now().getDayOfYear() == 1;
    }
}
