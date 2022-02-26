package com.example.demo.data.statistic.domain.statistic.entity.valueobject.strategy;

import com.example.demo.data.statistic.domain.statistic.entity.valueobject.DataTypeEnum;
import com.example.demo.data.statistic.domain.statistic.entity.valueobject.timefilter.*;
import com.example.demo.data.statistic.domain.statistic.repository.MetaDataRepository;
import com.example.demo.data.statistic.domain.statistic.repository.StrategyRepository;
import com.example.demo.data.statistic.po.DataOption;
import com.example.demo.data.statistic.po.ResourceData;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class ResourceUvStrategy extends AbstractStrategy {

    @Resource
    private MetaDataRepository metaDataRepository;

    public ResourceUvStrategy(StrategyRepository strategyRepository) {
        super(strategyRepository);

        this.timeFilterList = new ArrayList<>(4);
        this.timeFilterList.add(new DayFilter());
        this.timeFilterList.add(new WeekFilter());
        this.timeFilterList.add(new MonthFilter());
        this.timeFilterList.add(new YearFilter());
    }

    @Override
    public DataTypeEnum getId() {
        return DataTypeEnum.RESOURCE_UV;
    }

    @Override
    public void statisticData(TimeFilter timeFilter) {
        // 从 option 表里查询出，要统计的资源类型
        DataOption option = strategyRepository.findOption(this.getId().getKey());
        String[] resourceTypes = option.doGetStringArr();

        List<ResourceData> dataList = new ArrayList<>(resourceTypes.length);
        for (String resourceType : resourceTypes) {
            // 开始时间、结束时间
            LocalDateTime beginDate = this.getBeginDate(resourceType, timeFilter);
            LocalDateTime endDate = this.getEndDate(timeFilter);

            // 计算这段时间内的数据
            while (beginDate.isBefore(endDate)) {
                int count = metaDataRepository.countResourcePV(resourceType, beginDate, timeFilter.calNextDate(beginDate));

                dataList.add(new ResourceData(timeFilter.getBeginDate(), timeFilter.getEndDate(), timeFilter.getTYPE().getValue(),
                        resourceType, this.getId().getKey(), count));

                beginDate = timeFilter.calNextDate(beginDate);
            }
        }
        // 保存数据
        strategyRepository.saveResourceData(dataList);
    }

    protected LocalDateTime getBeginDate(String resourceType, TimeFilter timeFilter) {
        LocalDateTime beginDate = strategyRepository.findResourceDataBeginDate(resourceType,
                this.getId().getKey(), timeFilter.getTYPE().getValue());
        if (beginDate == null) {
            beginDate = timeFilter.getBeginDate();
        }
        return beginDate;
    }

    protected LocalDateTime getEndDate(TimeFilter timeFilter) {
        return timeFilter.getEndDate();
    }
}
