package com.example.demo.data.statistic.domain.statistic.entity.valueobject.strategy;

import com.example.demo.data.statistic.domain.statistic.entity.Satistic;
import com.example.demo.data.statistic.domain.statistic.entity.valueobject.DataTypeEnum;

public interface Strategy {

    /**
     * 返回类型
     *
     * @return 类型 {@link DataTypeEnum}
     */
    DataTypeEnum getId();

    /**
     * 比较是否相同
     */
    boolean isEqual(Strategy other);

    /**
     * 执行统计
     */
    void doStatistic(Satistic satistic);

}
