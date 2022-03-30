package com.example.demo.score.exchange.po;


import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @author author, auto generated on 2022-03-30
 */
@Getter
public class PrizePool {

    private Long id;
    /**
     * 关联的积分兑换ID
     */
    private Long exchangeId;
    /**
     * 关联的奖品ID
     */
    private Long prizeId;
    /**
     * 奖品的内容编码
     */
    private String code;
    /**
     * 是否已兑换
     */
    private Integer hasExchanged;
    /**
     * 参与用户ID
     */
    private Long userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
