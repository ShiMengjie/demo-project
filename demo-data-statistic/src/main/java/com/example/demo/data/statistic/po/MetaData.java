package com.example.demo.data.statistic.po;

import lombok.Getter;

import java.time.LocalDateTime;

/**
 * 元数据
 */
@Getter
public class MetaData {

    private Long id;

    /**
     * 设备唯一标识
     */
    private String deviceId;

    /**
     * 设备类型
     */
    private String deviceType;

    /**
     * 设备操作系统版本
     */
    private String deviceOsVersion;

    /**
     * 客户端APP版本
     */
    private String appVersion;

    /**
     * 用户唯一标识
     */
    private String userId;

    /**
     * 用户执行该操作时的IP
     */
    private String userIp;

    /**
     * 操作时间
     */
    private LocalDateTime operateAt;

    /**
     * 操作类型
     */
    private String operateType;

    /**
     * 资源类型
     */
    private String resourceType;

    /**
     * 资源ID
     */
    private String resourceId;

    /**
     * 记录创建时间
     */
    private LocalDateTime createdAt;
}
