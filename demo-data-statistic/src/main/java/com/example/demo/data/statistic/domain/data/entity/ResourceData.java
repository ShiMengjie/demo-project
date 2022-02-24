package com.example.demo.data.statistic.domain.data.entity;


import com.example.demo.data.statistic.domain.data.entity.valueobject.DataTypeEnum;

import java.time.LocalDateTime;

/**
 * 资源统计数据
 */
public class ResourceData {

    private Long id;
    /**
     * 统计开始时间
     */
    private LocalDateTime beginDate;
    /**
     * 统计结束时间
     */
    private LocalDateTime endDate;
    /**
     * 资源类型
     */
    private String resourceType;
    /**
     * 数据指标类型
     *
     * @see DataTypeEnum
     */
    private String dataType;
    /**
     * 统计数值
     */
    private Integer value;

    private LocalDateTime createdAt;

    public ResourceData() {
        this.createdAt = LocalDateTime.now();
    }

    public ResourceData(LocalDateTime beginDate, LocalDateTime endDate,
                        String resourceType, String dataType, int value) {
        this();
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.resourceType = resourceType;
        this.dataType = dataType;
        this.value = value;
    }
}
