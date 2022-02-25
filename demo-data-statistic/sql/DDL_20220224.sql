CREATE TABLE `meta_data`
(
    `id`                int(11)                         NOT NULL AUTO_INCREMENT COMMENT '主键',
    `device_id`         varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '设备唯一标识',
    `device_type`       varchar(20) COLLATE utf8mb4_bin NOT NULL COMMENT '设备类型',
    `device_os_version` varchar(20) COLLATE utf8mb4_bin          DEFAULT NULL COMMENT '设备操作系统版本',
    `app_version`       varchar(20) COLLATE utf8mb4_bin          DEFAULT NULL COMMENT '客户端APP版本',
    `user_id`           varchar(20) COLLATE utf8mb4_bin          DEFAULT NULL COMMENT '用户唯一标识',
    `user_ip`           varchar(64) COLLATE utf8mb4_bin          DEFAULT NULL COMMENT '用户IP',
    `operate_at`        datetime                        NOT NULL COMMENT '该操作发生时刻',
    `operate_type`      varchar(20) COLLATE utf8mb4_bin NOT NULL COMMENT '行为类型',
    `resource_type`     varchar(20) COLLATE utf8mb4_bin          DEFAULT NULL COMMENT '资源类型',
    `resource_id`       varchar(10) COLLATE utf8mb4_bin          DEFAULT NULL COMMENT '资源ID',
    `created_at`        timestamp                       NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    KEY `idx_device_id` (`device_id`),
    KEY `idx_operate_type` (`operate_type`),
    KEY `idx_resource_type_id` (`resource_type`, `resource_id`),
    KEY `idx_operate_at` (`operate_at`),
    KEY `idx_user_id` (`user_id`),
    KEY `idx_user_ip` (`user_ip`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='元数据记录表';

CREATE TABLE `resource_data`
(
    `id`            int(11)   NOT NULL AUTO_INCREMENT COMMENT '主键',
    `begin_date`    datetime  NOT NULL COMMENT '统计开始时间',
    `end_date`      datetime  NOT NULL COMMENT '统计结束时间',
    `resource_type` varchar(50)        DEFAULT NULL COMMENT '资源类型',
    `time_type`     varchar(20)        DEFAULT NULL COMMENT '时间类型',
    `data_type`     varchar(20)        DEFAULT NULL COMMENT '数据指标类型',
    `value`         int(11)            DEFAULT NULL COMMENT '统计数值',
    `created_at`    timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    KEY `idx_resource_type` (`resource_type`),
    KEY `idx_data_type` (`data_type`),
    KEY `idx_time_type` (`time_type`),
    KEY `idx_begin_date` (`begin_date`),
    KEY `idx_end_date` (`end_date`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='资源统计数据表';



CREATE TABLE `strategy_option`
(
    `id`         int(11)   NOT NULL AUTO_INCREMENT COMMENT '主键',
    `key`        varchar(50)        DEFAULT NULL COMMENT 'key',
    `value`      varchar(200)       DEFAULT NULL COMMENT 'value',
    `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    KEY `uk_key` (`key`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='统计策略的配置数据';