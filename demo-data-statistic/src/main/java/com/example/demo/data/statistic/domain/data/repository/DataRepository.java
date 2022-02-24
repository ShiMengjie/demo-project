package com.example.demo.data.statistic.domain.data.repository;

import com.example.demo.data.statistic.domain.data.entity.ResourceData;
import com.example.demo.data.statistic.domain.data.entity.DataOption;

import java.util.List;

public interface DataRepository {

    /**
     * 根据 key 查询 StrategyOption
     */
    DataOption findOption(String key);

    /**
     * 保存 ResourceData 数据
     */
    void saveResourceData(List<ResourceData> dataList);
}
