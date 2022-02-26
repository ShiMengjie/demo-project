package com.example.demo.data.statistic.domain.statistic.entity.valueobject;

/**
 * operate 枚举
 **/
public enum OperateEnum {
    // NONE
    NONE("NONE"),
    // 浏览资源
    VIEW_RESOURCE("VIEW_RES");

    private String value;

    OperateEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
