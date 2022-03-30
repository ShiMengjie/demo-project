package com.example.demo.score.exchange.po;


import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @author author, auto generated on 2022-03-30
 */
@Getter
public class Score {

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
     * 当前剩余的积分
     */
    private Long score;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
