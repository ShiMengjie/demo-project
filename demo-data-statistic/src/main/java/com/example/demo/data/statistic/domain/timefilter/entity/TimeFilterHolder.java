package com.example.demo.data.statistic.domain.timefilter.entity;

import com.example.demo.data.statistic.domain.timefilter.entity.valueobject.TimeFilterEnum;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * time filter holder
 **/
public class TimeFilterHolder {

    private final Map<TimeFilterEnum, TimeFilter> MAP = new HashMap<>(TimeFilterEnum.values().length);

    /**
     * 把 timeFilter 添加进 map
     */
    public void addTimeFilter(TimeFilter timeFilter) {
        this.MAP.put(timeFilter.getID(), timeFilter);
    }

    /**
     * 返回所有 TimeFilter
     */
    public Collection<TimeFilter> values() {
        return this.MAP.values();
    }
}
