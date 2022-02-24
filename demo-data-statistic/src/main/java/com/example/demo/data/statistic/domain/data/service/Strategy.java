package com.example.demo.data.statistic.domain.data.service;

import com.example.demo.data.statistic.domain.data.entity.valueobject.DataTypeEnum;
import com.example.demo.data.statistic.domain.timefilter.entity.TimeFilter;

public interface Strategy {

    /**
     * 返回类型
     *
     * @return 类型 {@link DataTypeEnum}
     */
    DataTypeEnum getId();

    /**
     * 统计 数据
     */
    void statisticData(TimeFilter timeFilter);

}
