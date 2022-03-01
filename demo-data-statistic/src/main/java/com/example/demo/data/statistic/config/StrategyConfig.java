package com.example.demo.data.statistic.config;

import com.example.demo.data.statistic.domain.index.entity.IndexChain;
import com.example.demo.data.statistic.domain.index.entity.valueobject.strategy.IndexStrategy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * Strategy 配置
 **/
@Configuration
public class StrategyConfig implements InitializingBean, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Bean
    public IndexChain strategyChain() {
        return new IndexChain();
    }

    @Override
    public void afterPropertiesSet() {
        // 把 StatisticHandler 添加进 StatisticHandlerChain 中
        IndexChain chain = applicationContext.getBean(IndexChain.class);

        Map<String, IndexStrategy> map = applicationContext.getBeansOfType(IndexStrategy.class);

        map.values().forEach(chain::addStrategy);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
