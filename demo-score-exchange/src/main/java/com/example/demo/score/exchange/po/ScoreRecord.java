package com.example.demo.score.exchange.po;


import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @author author, auto generated on 2022-03-30
 */
@Getter
public class ScoreRecord {
    private Long id;
    /**
     * 积分兑换的ID
     */
    private Long exchangeId;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 积分记录值
     */
    private Long score;
    /**
     * 对应的规则ID
     */
    private Long specificationId;
    /**
     * 规则对应的资源ID
     */
    private Long targetId;
    private LocalDateTime createdAt;
}
