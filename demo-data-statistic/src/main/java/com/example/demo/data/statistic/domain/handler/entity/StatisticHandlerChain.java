package com.example.demo.data.statistic.domain.handler.entity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StatisticHandlerChain {

    /**
     * The int which gives the current number of filters in the chain.
     */
    int size = 0;

    /**
     * handlers
     */
    Handler[] handlers = new Handler[0];

    /**
     * the current position in the filter chain.
     */
    int pos = 0;

    /**
     * increment
     */
    int INCREMENT = 10;

    public void addHandler(Handler newHandler) {
        // 避免重复添加
        for (Handler statisticHandler : handlers) {
            if (statisticHandler == newHandler) {
                return;
            }
        }
        // 如果已经满了，就扩容
        if (size == handlers.length) {
            Handler[] newHandlers = new Handler[size + INCREMENT];

            System.arraycopy(handlers, 0, newHandlers, 0, size);
            handlers = newHandlers;
        }
        handlers[size++] = newHandler;
    }

    public void doStatistic() {
        // Call the next filter if there is one
        if (pos < size) {
            Handler handler = handlers[pos++];
            try {
                handler.doStatistic(this);
            } catch (Exception e) {
                log.error("[StatisticHandlerChain] do statistic failed, cause error:", e);
            }
        }
    }

}
