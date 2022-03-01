package com.example.demo.data.statistic.po;

import com.example.demo.data.statistic.domain.index.entity.valueobject.DataTypeEnum;
import com.example.demo.data.statistic.domain.index.entity.valueobject.timefilter.TimeFilterEnum;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserData {

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

    public UserData() {
        this.createdAt = LocalDateTime.now();
    }

    public UserData(LocalDateTime beginDate, LocalDateTime endDate, String timeType,
                    String dataType, int value) {
        this();
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.timeType = timeType;
        this.dataType = dataType;
        this.value = value;
    }
}
