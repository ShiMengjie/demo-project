package com.example.demo.data.statistic.domain.index.entity.valueobject.strategy;

import com.example.demo.data.statistic.domain.index.entity.IndexChain;
import com.example.demo.data.statistic.domain.index.entity.valueobject.DataTypeEnum;

public interface Index {

    /**
     * 返回类型
     *
     * @return 类型 {@link DataTypeEnum}
     */
    DataTypeEnum getId();

    /**
     * 比较是否相同
     */
    boolean isEqual(Index other);

    /**
     * 执行统计
     */
    void doStatistic(IndexChain chain);

}
