package com.example.demo.data.statistic.strategy;


import com.example.demo.data.statistic.domain.strategy.entity.Strategy;
import com.example.demo.data.statistic.domain.metadata.entity.DataEntity;

public abstract class AbstractStrategy implements Strategy {

    @Override
    public void statisticData(DataEntity entity) {
    }
}
