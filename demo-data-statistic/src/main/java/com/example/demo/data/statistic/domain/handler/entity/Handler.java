package com.example.demo.data.statistic.domain.handler.entity;


public interface Handler {

    /**
     * 执行统计任务
     *
     * @param statisticChain StatisticHandlerChain
     */
    void doStatistic(StatisticHandlerChain statisticChain);
}
