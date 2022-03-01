package com.example.demo.data.statistic.domain.index.entity.valueobject;

/**
 * 统计的指标枚举
 **/
public enum DataTypeEnum {
    //
    NONE("NONE", OperateEnum.NONE),
    // 资源被浏览的 PV
    RESOURCE_PV("RES_PV", OperateEnum.VIEW_RESOURCE),
    // 资源被浏览的 UV
    RESOURCE_UV("RES_UV", OperateEnum.VIEW_RESOURCE);

    /**
     * 指标名称
     */
    private String key;
    /**
     * 对应的行为类型
     */
    private OperateEnum value;

    DataTypeEnum(String key, OperateEnum value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public OperateEnum getValue() {
        return this.value;
    }
}
