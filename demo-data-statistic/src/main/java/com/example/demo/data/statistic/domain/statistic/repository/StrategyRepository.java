package com.example.demo.data.statistic.domain.statistic.repository;

import com.example.demo.data.statistic.po.DataOption;
import com.example.demo.data.statistic.po.ResourceData;

import java.time.LocalDateTime;
import java.util.List;

public interface StrategyRepository {

    /**
     * 根据 key 查询 StrategyOption
     */
    DataOption findOption(String key);

    /**
     * 本次统计资源相关指标的开始时间
     */
    LocalDateTime findResourceDataBeginDate(String resourceType, String dataType, String timeType);

    /**
     * 保存 ResourceData 数据
     */
    void saveResourceData(List<ResourceData> dataList);
}
