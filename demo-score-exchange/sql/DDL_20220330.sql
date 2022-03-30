CREATE TABLE `score_exchange`
(
    `id`         int(11)     NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `title`      varchar(50) NOT NULL COMMENT '兑换名称',
    `start_time` timestamp   NOT NULL COMMENT '兑换开始时间',
    `end_time`   timestamp   NOT NULL COMMENT '兑换结束时间',
    `created_at` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='积分兑换表';


CREATE TABLE `prize`
(
    `id`             int(11)      NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `exchange_id`    int(11)      NOT NULL COMMENT '关联的奖品兑换ID',
    `prize_name`     varchar(50)  NOT NULL COMMENT '奖品名称',
    `pic_url`        varchar(200) NOT NULL COMMENT '奖品图片',
    `init_num`       smallint(6)  NOT NULL COMMENT '奖品初始数量,-1表示不限量',
    `remain_num`     smallint(6)  NOT NULL COMMENT '奖品剩余数量',
    `exchange_score` mediumint(9) NOT NULL COMMENT '兑换消耗的积分',
    `limit_type`     tinyint(4)   NOT NULL COMMENT '奖品兑换限制类型,0-每个人无兑换上限,1-每个人有兑换上限',
    `limit_number`   tinyint(4)   NOT NULL DEFAULT '-1' COMMENT '每个人的兑换上限,-1表示不限量',
    `is_real`        tinyint(1)   NOT NULL DEFAULT '0' COMMENT '是否是实物奖品',
    `created_at`     timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`     timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    KEY `idx_exchange_id` (`exchange_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='积分兑换的奖品表';


CREATE TABLE `prize_pool`
(
    `id`            int(11)    NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `exchange_id`   int(11)    NOT NULL COMMENT '关联的积分兑换ID,对应 score_exchange 表id',
    `prize_id`      int(11)    NOT NULL COMMENT '关联的奖品ID,对应 score_exchange_prize 表id',
    `code`          varchar(20)         DEFAULT NULL COMMENT '奖品的内容编码',
    `has_exchanged` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已兑换',
    `user_id`       int(11)             DEFAULT NULL COMMENT '参与用户ID',
    `created_at`    timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`    timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    KEY `idx_prize_status` (`prize_id`, `has_exchanged`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='积分兑换的奖品池';


CREATE TABLE `prize_record`
(
    `id`          int(11)   NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `user_id`     int(11)   NOT NULL COMMENT '参与用户ID',
    `exchange_id` int(11)   NOT NULL COMMENT '积分兑换ID',
    `prize_id`    int(11)   NOT NULL COMMENT '奖品ID',
    `created_at`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    KEY `idx_exchange_id` (`exchange_id`),
    KEY `idx_user_id` (`user_id`),
    KEY `idx_prize_id` (`prize_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户积分兑换奖品记录';


CREATE TABLE `score_specification`
(
    `id`           int(11)     NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `exchange_id`  int(11)     NOT NULL COMMENT '关联的积分兑换ID,对应 score_exchange 表id',
    `operate_type` varchar(20) NOT NULL COMMENT '行为类型',
    `score`        tinyint(4)           DEFAULT NULL COMMENT '对应的积分值',
    `created_at`   timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`   timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    KEY `idx_exchange` (`exchange_id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='积分规则表';


CREATE TABLE `score`
(
    `id`          int(11)      NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `exchange_id` int(11)      NOT NULL COMMENT '积分兑换的ID',
    `user_id`     int(11)      NOT NULL COMMENT '用户ID',
    `score`       mediumint(9) NOT NULL DEFAULT '1' COMMENT '当前剩余的积分',
    `created_at`  timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`  timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_exchange_user` (`exchange_id`, `user_id`),
    KEY `idx_user_id` (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='积分表';


CREATE TABLE `score_record`
(
    `id`               int(11)      NOT NULL AUTO_INCREMENT,
    `exchange_id`      int(11)      NOT NULL COMMENT '积分兑换的ID',
    `user_id`          int(11)      NOT NULL COMMENT '用户ID',
    `score`            mediumint(9) NOT NULL COMMENT '积分记录值',
    `specification_id` int(11)      NOT NULL COMMENT '对应的规则ID',
    `target_id`        varchar(32)  NOT NULL COMMENT '规则对应的资源ID,比如邀请的用户ID,兑换的奖品ID等',
    `created_at`       timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    KEY `idx_exchange_id` (`exchange_id`),
    KEY `idx_user_id` (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='积分记录表';

CREATE TABLE `user`
(
    `id`              int(11)     NOT NULL AUTO_INCREMENT,
    `exchange_id`     int(11)     NOT NULL COMMENT '积分兑换的ID',
    `phone`           varchar(30) NOT NULL COMMENT '手机号',
    `name`            varchar(30) NOT NULL COMMENT '昵称',
    `invitation_code` char(8)     NOT NULL COMMENT '自己的邀请码，8个字符长度，大写英文和数字混合',
    `invited_code`    char(8)              DEFAULT NULL COMMENT '报名时填写的的邀请码',
    `created_at`      timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`      timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_phone` (`phone`),
    UNIQUE KEY `uk_name` (`name`),
    UNIQUE KEY `uk_invitation` (`invitation_code`),
    KEY `idx_exchange` (`exchange_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='参与积分兑换的用户表';