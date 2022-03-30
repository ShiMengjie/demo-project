package com.example.demo.score.exchange.po;


import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @author author, auto generated on 2022-03-30
 */
@Getter
public class ScoreSpecification {

    private Long id;
    /**
     * 关联的积分兑换ID
     */
    private Long exchangeId;
    /**
     * 行为类型
     */
    private String operateType;
    /**
     * 对应的积分值
     */
    private Integer score;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
