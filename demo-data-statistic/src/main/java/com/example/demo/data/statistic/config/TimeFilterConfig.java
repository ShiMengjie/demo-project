package com.example.demo.data.statistic.config;

import com.example.demo.data.statistic.domain.timefilter.entity.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * time filter config
 **/
@Configuration
public class TimeFilterConfig {

    @Bean
    public TimeFilterHolder timeFilterHolder() {
        TimeFilterHolder holder = new TimeFilterHolder();
        holder.addTimeFilter(new DayFilter());
        holder.addTimeFilter(new WeekFilter());
        holder.addTimeFilter(new MonthFilter());
        holder.addTimeFilter(new YearFilter());
        return holder;
    }
}
