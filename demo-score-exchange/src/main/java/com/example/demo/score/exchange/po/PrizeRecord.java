package com.example.demo.score.exchange.po;


import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @author author, auto generated on 2022-03-30
 */
@Getter
public class PrizeRecord {

    private Long id;
    /**
     * 参与用户ID
     */
    private Long userId;
    /**
     * 积分兑换ID
     */
    private Long exchangeId;
    /**
     * 奖品ID
     */
    private Long prizeId;
    private LocalDateTime createdAt;
}
