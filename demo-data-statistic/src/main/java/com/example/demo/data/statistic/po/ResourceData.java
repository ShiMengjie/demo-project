package com.example.demo.data.statistic.po;


import com.example.demo.data.statistic.domain.index.entity.valueobject.DataTypeEnum;
import com.example.demo.data.statistic.domain.index.entity.valueobject.timefilter.TimeFilterEnum;

import java.time.LocalDateTime;

/**
 * 资源统计数据
 *
 * @author xxx
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
     * 时间类型
     *
     * @see TimeFilterEnum
     */
    private String timeType;
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

    public ResourceData(LocalDateTime beginDate, LocalDateTime endDate, String timeType,
                        String resourceType, String dataType, int value) {
        this();
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.timeType = timeType;
        this.resourceType = resourceType;
        this.dataType = dataType;
        this.value = value;
    }
}
