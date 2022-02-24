package com.example.demo.data.statistic.domain.handler.entity;

import com.example.demo.data.statistic.domain.handler.entity.valueobject.HandlerEnum;
import com.example.demo.data.statistic.domain.data.service.Strategy;
import com.example.demo.data.statistic.domain.data.service.StrategyHolder;
import com.example.demo.data.statistic.domain.data.entity.valueobject.DataTypeEnum;
import com.example.demo.data.statistic.domain.timefilter.entity.TimeFilter;
import com.example.demo.data.statistic.domain.timefilter.entity.TimeFilterHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 统计资源的 handler
 */
@Slf4j
@Component
public class ResourceHandler extends AbstractHandler {

    /**
     * handler enum
     */
    private final HandlerEnum ID = HandlerEnum.RESOURCE;

    /**
     * 通过 strategyHolder 持有 strategy，解耦
     */
    @Resource
    private StrategyHolder strategyHolder;

    /**
     * 负责统计的指标列表
     */
    private List<DataTypeEnum> dataTypeEnums;

    public ResourceHandler(TimeFilterHolder timeFilterHolder) {
        super(timeFilterHolder);

        this.dataTypeEnums = new ArrayList<>(DataTypeEnum.values().length);
        this.dataTypeEnums.addAll(Arrays.asList(DataTypeEnum.values()));
    }

    /**
     * 执行内部统计方法，计算每一个统计指标
     *
     * @param timeFilter TimeFilter
     */
    @Override
    public void doInternalStatistic(TimeFilter timeFilter) {
        for (DataTypeEnum dataTypeEnum : this.dataTypeEnums) {
            Strategy strategy = this.strategyHolder.getStrategy(dataTypeEnum);
            strategy.statisticData(timeFilter);
        }
    }
}
