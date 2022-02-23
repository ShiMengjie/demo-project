package com.example.demo.data.statistic.config;

import com.example.demo.data.statistic.domain.handler.entity.Handler;
import com.example.demo.data.statistic.domain.handler.entity.StatisticHandler;
import com.example.demo.data.statistic.domain.handler.entity.StatisticHandlerChain;
import com.example.demo.data.statistic.domain.timefilter.entity.valueobject.TimeFilterEnum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Handler 配置
 **/
@Configuration
public class HandlerConfig {

    @Bean
    public StatisticHandlerChain statisticHandlerChain(Handler handler) {
        StatisticHandlerChain chain = new StatisticHandlerChain();
        chain.addHandler(handler);
        return chain;
    }

    @Bean
    public Handler statisticHandler() {
        Handler handler = new StatisticHandler();
        handler.addTimeFilter(TimeFilterEnum.DAY);
        handler.addTimeFilter(TimeFilterEnum.WEEK);
        handler.addTimeFilter(TimeFilterEnum.MONTH);
        handler.addTimeFilter(TimeFilterEnum.YEAR);
        return handler;
    }

}
