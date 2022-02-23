package com.example.demo.data.statistic.domain.strategy.entity;

import com.example.demo.data.statistic.domain.metadata.entity.DataEntity;
import com.example.demo.data.statistic.constant.DataTypeConstant;
import com.example.demo.data.statistic.domain.timefilter.entity.TimeFilter;

public interface Strategy {

    /**
     * 返回类型
     *
     * @return 类型 {@link DataTypeConstant}
     */
    String getType();

    /**
     * 统计 数据
     */
    void statisticData(DataEntity entity);

    /**
     * 是否运行
     */
    boolean canRun(TimeFilter timeFilter);

}
