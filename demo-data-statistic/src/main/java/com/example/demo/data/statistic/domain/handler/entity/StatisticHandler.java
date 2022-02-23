package com.example.demo.data.statistic.domain.handler.entity;

import com.example.demo.data.statistic.domain.handler.entity.valueobject.HandlerEnum;
import com.example.demo.data.statistic.domain.metadata.entity.DataEntity;
import com.example.demo.data.statistic.domain.strategy.entity.Strategy;
import com.example.demo.data.statistic.domain.strategy.entity.StrategyHolder;
import com.example.demo.data.statistic.domain.timefilter.entity.TimeFilter;
import com.example.demo.data.statistic.domain.timefilter.entity.TimeFilterHolder;
import com.example.demo.data.statistic.domain.timefilter.entity.valueobject.TimeFilterEnum;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

/**
 * 统计 handler
 */
@Slf4j
public class StatisticHandler implements Handler {

    /**
     * handler enum
     */
    private final HandlerEnum handlerEnum = HandlerEnum.RESOURCE;

    /**
     * 通过 strategyHolder 简介持有 strategy，解耦
     */
    @Resource
    private StrategyHolder strategyHolder;

    /**
     * 通过 TimeFilterHolder 简介持有 timeFilter
     */
    @Resource
    private TimeFilterHolder timeFilterHolder;

    @Override
    public void doStatistic(StatisticHandlerChain statisticChain) {
        for (TimeFilter timeFilter : timeFilterHolder.values()) {
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
    private void doInternalStatistic(TimeFilter timeFilter) {
        for (Strategy strategy : strategyHolder.values()) {
            // 有的指标只在某些时刻运行
            if (!strategy.canRun(timeFilter)) {
                continue;
            }
            // 每个 timeFilter、dataType 新建一个 ResourceOperateEntity 对象
            strategy.statisticData(new DataEntity(timeFilter));
        }
    }

}
