package com.example.demo.data.statistic.config;

import com.example.demo.data.statistic.constant.JobConstant;
import com.example.demo.data.statistic.job.StatisticJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfig {

    /**
     * 注册 Job
     */
    @Bean
    public JobDetail dailyJobDetail() {
        return JobBuilder.newJob(StatisticJob.class)
                .withIdentity(JobConstant.JobDetail.JOB_DETAIL, JobConstant.JobDetailGroup.JOB_DETAIL_GROUP)
                .storeDurably()
                .build();
    }

    /**
     * 注册 Trigger，每天凌晨1点执行一次
     */
    @Bean
    public Trigger dailyTrigger() {
        return TriggerBuilder.newTrigger()
                .forJob(dailyJobDetail())
                .withIdentity(JobConstant.Trigger.JOB_TRIGGER, JobConstant.TriggerGroup.JOB_TRIGGER_GROUP)
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0 1 * * ?"))
                .build();
    }
}
