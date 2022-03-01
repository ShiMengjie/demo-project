package com.example.demo.data.statistic.domain.index.entity.valueobject.strategy;

import com.example.demo.data.statistic.domain.index.entity.IndexChain;
import com.example.demo.data.statistic.domain.index.entity.valueobject.timefilter.TimeFilter;
import com.example.demo.data.statistic.domain.index.repository.StrategyRepository;

import java.util.List;

public abstract class AbstractStrategy implements IndexStrategy {

    /**
     * 在这些时间点，可以执行统计
     */
    protected List<TimeFilter> timeFilterList;

    protected StrategyRepository strategyRepository;

    public AbstractStrategy(StrategyRepository strategyRepository) {
        this.strategyRepository = strategyRepository;
    }

    @Override
    public boolean isEqual(IndexStrategy other) {
        return this.getId().equals(other.getId());
    }

    @Override
    public void doStatistic(IndexChain satistic) {
        for (TimeFilter timeFilter : this.timeFilterList) {
            // 当前时间是否需要进行统计
            if (!timeFilter.canDoStatistic()) {
                continue;
            }
            // 执行内部统计方法
            this.execute(timeFilter);
        }
        // chain 中下一个 handler 的统计
        satistic.doStatistic();
    }

    /**
     * 真正执行统计的方法
     */
    protected abstract void execute(TimeFilter timeFilter);
}
