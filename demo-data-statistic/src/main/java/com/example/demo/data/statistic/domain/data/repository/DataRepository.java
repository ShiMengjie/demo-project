package com.example.demo.data.statistic.domain.data.repository;

import com.example.demo.data.statistic.domain.data.entity.DataOption;
import com.example.demo.data.statistic.domain.data.entity.ResourceData;

import java.time.LocalDateTime;
import java.util.List;

public interface DataRepository {

    /**
     * 根据 key 查询 StrategyOption
     */
    DataOption findOption(String key);

    /**
     * 查询本次统计的开始时间
     */
    LocalDateTime findResourceBeginDate(String resourceType, String dataType, String timeType);

    /**
     * 保存 ResourceData 数据
     */
    void saveResourceData(List<ResourceData> dataList);
}
