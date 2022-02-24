package com.example.demo.data.statistic.domain.metadata.entity.valueobject;

/**
 * operate 枚举
 **/
public enum OperateEnum {

    VIEW_RESOURCE("VIEW_RESOURCE");

    private String value;

    OperateEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
