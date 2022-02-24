package com.example.demo.data.statistic.domain.handler.entity;


import com.example.demo.data.statistic.domain.timefilter.entity.TimeFilter;
import com.example.demo.data.statistic.domain.timefilter.entity.TimeFilterHolder;

/**
 * @author shimengjie
 * @date 2022/2/24 19:20
 **/
public abstract class AbstractHandler implements Handler {

    /**
     * 通过 TimeFilterHolder 简介持有 timeFilter
     */
    protected TimeFilterHolder timeFilterHolder;

    public AbstractHandler(TimeFilterHolder timeFilterHolder) {
        this.timeFilterHolder = timeFilterHolder;
    }

    @Override
    public void doStatistic(StatisticHandlerChain statisticChain) {
        for (TimeFilter timeFilter : this.timeFilterHolder.values()) {
            // 当前时间是否需要进行统计
            if (!timeFilter.canDoStatistic()) {
                continue;
            }
            // 执行内部统计方法
            this.doInternalStatistic(timeFilter);
        }
        // chain 中下一个 handler 的统计
        statisticChain.doStatistic();
    }

    /**
     * 执行内部统计方法，计算每一个统计指标
     *
     * @param timeFilter TimeFilter
     */
    abstract void doInternalStatistic(TimeFilter timeFilter);
}
