package com.example.demo.data.statistic.domain.timefilter.entity.valueobject;

/**
 * timeFilter 的枚举
 **/
public enum TimeFilterEnum {
    //
    DAY("DAY"),
    WEEK("WEEK"),
    MONTH("MONTH"),
    YEAR("YEAR");

    private String value;

    TimeFilterEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
