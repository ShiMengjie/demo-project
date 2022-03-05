package com.example.demo.data.statistic.domain.index.entity;

import com.example.demo.data.statistic.domain.index.entity.valueobject.strategy.Index;
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
    Index[] indexArr = new Index[10];

    /**
     * the current position in the filter chain.
     */
    int pos = 0;

    /**
     * increment
     */
    int INCREMENT = 10;

    public void addStrategy(Index index) {
        for (Index existed : this.indexArr) {
            if(existed != null && existed.isEqual(index)) {
                if (existed.isEqual(index)) {
                    return;
                }
            }
        }

        // 如果已经满了，就扩容
        if (this.size == this.indexArr.length) {
            Index[] newIndexArr = new Index[this.size + this.INCREMENT];

            System.arraycopy(this.indexArr, 0, newIndexArr, 0, this.size);
            this.indexArr = newIndexArr;
        }
        this.indexArr[this.size++] = index;
    }

    public void doStatistic() {
        // Call the next filter if there is one
        if (this.pos < this.size) {
            Index index = this.indexArr[this.pos++];
            try {
                index.doStatistic(this);
            } catch (Exception e) {
                log.error("[StrategyChain] do statistic failed, cause error:", e);
            }
        }
    }

}
