package com.example.demo.data.statistic.domain.metadata.entity;

import com.example.demo.data.statistic.domain.timefilter.entity.TimeFilter;

public class DataEntity {

    private TimeFilter timeFilter;

    public DataEntity(TimeFilter timeFilter) {
        this.timeFilter = timeFilter;
    }
}
