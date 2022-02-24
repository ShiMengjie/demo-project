package com.example.demo.data.statistic.domain.data.entity.valueobject;

/**
 * 统计的指标枚举
 **/
public enum DataTypeEnum {
    //
    NONE("NONE"),
    // 资源被访问的 PV
    RESOURCE_PV("RES_PV"),
    // 资源被访问的 UV
    RESOURCE_UV("RES_UV"),
    // 用户登录 UV
    USER_LOGIN_UV("USR_LOGIN_UV");

    private String value;

    DataTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
