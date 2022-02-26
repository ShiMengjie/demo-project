package com.example.demo.data.statistic.job;

import com.example.demo.data.statistic.domain.statistic.entity.Satistic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * 统计任务
 **/
@Slf4j
@Component
public class StatisticJob {

    @Resource
    private Satistic strategyChain;

    @Scheduled(cron = "0 0 1 * * ?")
    protected void execute() {
        log.info("statistic job is begin..., now begin time is :{}", LocalDateTime.now());

        strategyChain.doStatistic();

        log.info("statistic job is end ..., end time is :{} ", LocalDateTime.now());
    }

}
