package com.example.demo.data.statistic.dao.mapper;

import com.example.demo.data.statistic.domain.data.entity.ResourceData;

import java.util.List;

public interface ResourceDataMapper {

    /**
     * 批量插入
     */
    void insertList(List<ResourceData> dataList);
}
