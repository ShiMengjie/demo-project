package com.example.demo.score.exchange.po;


import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @author author, auto generated on 2022-03-30
 */
@Getter
public class User {
    private Long id;
    /**
     * 积分兑换的ID
     */
    private Long exchangeId;
    /**
     *手机号
     */
    private String phone;
    /**
     * 昵称
     */
    private String name;
    /**
     * 自己的邀请码
     */
    private String invitationCode;
    /**
     * 报名时填写的的邀请码
     */
    private String invitedCode;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
