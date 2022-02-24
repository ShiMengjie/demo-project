package com.example.demo.data.statistic.domain.data.service.impl;

import com.example.demo.data.statistic.domain.data.entity.ResourceData;
import com.example.demo.data.statistic.domain.data.entity.DataOption;
import com.example.demo.data.statistic.domain.data.entity.valueobject.DataTypeEnum;
import com.example.demo.data.statistic.domain.data.repository.DataRepository;
import com.example.demo.data.statistic.domain.data.service.Strategy;
import com.example.demo.data.statistic.domain.metadata.entity.valueobject.OperateEnum;
import com.example.demo.data.statistic.domain.metadata.repository.MetaDataRepository;
import com.example.demo.data.statistic.domain.timefilter.entity.TimeFilter;
import com.example.demo.data.statistic.domain.timefilter.entity.valueobject.TimeFilterEnum;
import com.google.common.collect.Sets;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 资源 PV 统计策略
 **/
@Component
public class ResourcePvStrategy implements Strategy {

    @Resource
    private MetaDataRepository metaDataRepository;
    @Resource
    private DataRepository dataRepository;

    /**
     * 在这些时间点，可以执行 资源 PV统计
     */
    private final Set<TimeFilterEnum> TIME_FILTER_ENUMS = Sets.immutableEnumSet(
            TimeFilterEnum.DAY, TimeFilterEnum.WEEK,
            TimeFilterEnum.MONTH, TimeFilterEnum.YEAR);

    @Override
    public DataTypeEnum getId() {
        return DataTypeEnum.RESOURCE_PV;
    }

    @Override
    public void statisticData(TimeFilter timeFilter) {
        if (!this.canRun(timeFilter)) {
            return;
        }
        // 从 option 表里查询出，要统计的资源类型
        DataOption option = dataRepository.findOption(this.getId().getValue());
        String[] resourceTypes = option.doGetStringArr();

        List<ResourceData> dataList = new ArrayList<>(resourceTypes.length);
        for (String resourceType : resourceTypes) {
            int count = metaDataRepository.countResourcePV(resourceType, OperateEnum.VIEW_RESOURCE.getValue(),
                    timeFilter.getStartDate(), timeFilter.getEndDate());
            dataList.add(new ResourceData(timeFilter.getStartDate(), timeFilter.getEndDate(), resourceType,
                    this.getId().getValue(), count));
        }
        // 保存数据
        dataRepository.saveResourceData(dataList);
    }

    /**
     * 是否执行
     */
    private boolean canRun(TimeFilter timeFilter) {
        return TIME_FILTER_ENUMS.contains(timeFilter.getID());
    }
}
