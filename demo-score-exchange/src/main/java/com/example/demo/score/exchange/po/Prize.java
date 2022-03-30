package com.example.demo.score.exchange.po;


import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @author author, auto generated on 2022-03-30
 */
@Getter
public class Prize {

    private Long id;
    /**
     * 关联的奖品兑换ID
     */
    private Long exchangeId;
    /**
     *奖品名称
     */
    private String prizeName;
    /**
     * 奖品图片
     */
    private String picUrl;
    /**
     * 奖品初始数量
     */
    private Long initNum;
    /**
     * 奖品剩余数量
     */
    private Long remainNum;
    /**
     * 兑换消耗的积分
     */
    private Long exchangeScore;
    /**
     * 奖品兑换限制类型
     */
    private Integer limitType;
    /**
     * 每个人的兑换上限
     */
    private Integer limitNumber;
    /**
     * 是否是实物奖品
     */
    private Integer isReal;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
