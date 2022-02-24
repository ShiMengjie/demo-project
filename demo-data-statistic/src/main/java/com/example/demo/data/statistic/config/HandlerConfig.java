package com.example.demo.data.statistic.config;

import com.example.demo.data.statistic.domain.handler.entity.Handler;
import com.example.demo.data.statistic.domain.handler.entity.StatisticHandlerChain;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * Handler 配置
 **/
@Configuration
public class HandlerConfig implements InitializingBean, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Bean
    public StatisticHandlerChain statisticHandlerChain() {
        return new StatisticHandlerChain();
    }

    @Override
    public void afterPropertiesSet() {
        // 把 StatisticHandler 添加进 StatisticHandlerChain 中
        StatisticHandlerChain handlerChain = applicationContext.getBean(StatisticHandlerChain.class);

        Map<String, Handler> handlerMap = applicationContext.getBeansOfType(Handler.class);

        handlerMap.values().forEach(handlerChain::addHandler);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
