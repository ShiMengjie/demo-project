package com.example.demo.data.statistic.domain.handler.entity.valueobject;

/**
 * handler 的枚举
 */
public enum HandlerEnum {
    // 资源先关的 handler
    RESOURCE("RESOURCE"),
    // 用户相关的 handler
    USER("USER");

    private String value;

    HandlerEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
