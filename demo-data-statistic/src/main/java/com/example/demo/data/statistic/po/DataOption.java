package com.example.demo.data.statistic.po;

/**
 * 统计策略的选项
 **/
public class DataOption {

    private Long id;
    /**
     * key 值
     */
    private String key;

    /**
     * 内容
     */
    private String value;

    /**
     * 把 value 按照逗号分隔成字符串数组
     */
    public String[] doGetStringArr() {
        return this.value.split(",");
    }
}
