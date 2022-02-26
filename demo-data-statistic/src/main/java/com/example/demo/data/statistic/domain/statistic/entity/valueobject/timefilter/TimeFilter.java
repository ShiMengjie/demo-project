package com.example.demo.data.statistic.domain.statistic.entity.valueobject.timefilter;

import java.time.LocalDateTime;

public interface TimeFilter {

    /**
     * 类型
     */
    TimeFilterEnum getTYPE();

    /**
     * 当前时间是否能够执行统计
     *
     * @return true/false
     */
    boolean canDoStatistic();

    /**
     * 计算下一个统计时间
     *
     * @param curDate 当前开始时间
     * @return LocalDateTime
     */
    LocalDateTime calNextDate(LocalDateTime curDate);

    /**
     * 返回计算的结束时间
     *
     * @return LocalDateTime
     */
    LocalDateTime getEndDate();

    /**
     * 返回计算的开始时间
     *
     * @return LocalDateTime
     */
    LocalDateTime getBeginDate();
}
