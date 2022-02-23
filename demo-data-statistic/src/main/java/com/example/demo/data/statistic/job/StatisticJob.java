package com.example.demo.data.statistic.job;

import com.example.demo.data.statistic.domain.handler.entity.StatisticHandlerChain;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * 统计任务
 **/
@Slf4j
@Component
public class StatisticJob extends QuartzJobBean {

    @Resource
    private StatisticHandlerChain statisticHandlerChain;

    @Override
    protected void executeInternal(JobExecutionContext context) {
        log.info("statistic job is begin..., now begin time is :{}", LocalDateTime.now());

        statisticHandlerChain.doStatistic();

        log.info("statistic job is end ..., end time is :{} ", LocalDateTime.now());
    }

}
