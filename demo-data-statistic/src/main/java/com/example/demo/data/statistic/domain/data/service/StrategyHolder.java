package com.example.demo.data.statistic.domain.data.service;

import com.example.demo.data.statistic.domain.data.entity.valueobject.DataTypeEnum;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class StrategyHolder implements InitializingBean, ApplicationContextAware {

    private final Map<DataTypeEnum, Strategy> STRATEGY_MAP = new HashMap<>(10);

    private ApplicationContext applicationContext;

    /**
     * 返回 strategy
     */
    public Strategy getStrategy(DataTypeEnum typeEnum) {
        return this.STRATEGY_MAP.get(typeEnum);
    }

    @Override
    public void afterPropertiesSet() {
        applicationContext.getBeansOfType(Strategy.class)
                .values()
                .forEach(strategy -> STRATEGY_MAP.put(strategy.getId(), strategy));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

