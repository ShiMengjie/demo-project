package com.example.demo.data.statistic.domain.statistic.entity;

import com.example.demo.data.statistic.domain.statistic.entity.valueobject.strategy.Strategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Satistic {

    /**
     * The int which gives the current number of filters in the chain.
     */
    int size = 0;

    /**
     * Strategy
     */
    Strategy[] strategies = new Strategy[10];

    /**
     * the current position in the filter chain.
     */
    int pos = 0;

    /**
     * increment
     */
    int INCREMENT = 10;

    public void addStrategy(Strategy other) {
        for (Strategy strategy : this.strategies) {
            if(strategy != null && strategy.isEqual(other)) {
                if (strategy.isEqual(other)) {
                    return;
                }
            }
        }

        // 如果已经满了，就扩容
        if (this.size == this.strategies.length) {
            Strategy[] newHandlers = new Strategy[this.size + this.INCREMENT];

            System.arraycopy(this.strategies, 0, newHandlers, 0, this.size);
            this.strategies = newHandlers;
        }
        this.strategies[this.size++] = other;
    }

    public void doStatistic() {
        // Call the next filter if there is one
        if (this.pos < this.size) {
            Strategy strategy = this.strategies[this.pos++];
            try {
                strategy.doStatistic(this);
            } catch (Exception e) {
                log.error("[StrategyChain] do statistic failed, cause error:", e);
            }
        }
    }

}
