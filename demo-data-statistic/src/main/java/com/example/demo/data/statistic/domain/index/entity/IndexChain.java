package com.example.demo.data.statistic.domain.index.entity;

import com.example.demo.data.statistic.domain.index.entity.valueobject.strategy.IndexStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IndexChain {

    /**
     * The int which gives the current number of filters in the chain.
     */
    int size = 0;

    /**
     * Strategy
     */
    IndexStrategy[] strategies = new IndexStrategy[10];

    /**
     * the current position in the filter chain.
     */
    int pos = 0;

    /**
     * increment
     */
    int INCREMENT = 10;

    public void addStrategy(IndexStrategy other) {
        for (IndexStrategy strategy : this.strategies) {
            if(strategy != null && strategy.isEqual(other)) {
                if (strategy.isEqual(other)) {
                    return;
                }
            }
        }

        // 如果已经满了，就扩容
        if (this.size == this.strategies.length) {
            IndexStrategy[] newHandlers = new IndexStrategy[this.size + this.INCREMENT];

            System.arraycopy(this.strategies, 0, newHandlers, 0, this.size);
            this.strategies = newHandlers;
        }
        this.strategies[this.size++] = other;
    }

    public void doStatistic() {
        // Call the next filter if there is one
        if (this.pos < this.size) {
            IndexStrategy strategy = this.strategies[this.pos++];
            try {
                strategy.doStatistic(this);
            } catch (Exception e) {
                log.error("[StrategyChain] do statistic failed, cause error:", e);
            }
        }
    }

}
