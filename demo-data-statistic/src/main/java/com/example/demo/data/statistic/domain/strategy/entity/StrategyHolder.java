package com.example.demo.data.statistic.domain.strategy.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class StrategyHolder implements InitializingBean, ApplicationContextAware {

    private final Map<String, Strategy> STRATEGY_MAP = new HashMap<>(10);

    private ApplicationContext applicationContext;

    /**
     * 返回 strategy 列表
     */
    public Collection<Strategy> values() {
        return this.STRATEGY_MAP.values();
    }

    @Override
    public void afterPropertiesSet() {
        applicationContext.getBeansOfType(Strategy.class)
                .values()
                .forEach(strategy -> STRATEGY_MAP.put(strategy.getType(), strategy));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

