package com.example.demo.score.exchange.po;


import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @author author, auto generated on 2022-03-30
 */
@Getter
public class ScoreExchange {

    private Long id;
    /**
     * 兑换名称
     */
    private String title;
    /**
     *兑换开始时间
     */
    private LocalDateTime startTime;
    /**
     * 兑换结束时间
     */
    private LocalDateTime endTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
