package com.example.demo.data.statistic.dao.repository;

import com.example.demo.data.statistic.dao.mapper.DataOptionMapper;
import com.example.demo.data.statistic.dao.mapper.ResourceDataMapper;
import com.example.demo.data.statistic.domain.data.entity.DataOption;
import com.example.demo.data.statistic.domain.data.entity.ResourceData;
import com.example.demo.data.statistic.domain.data.repository.DataRepository;
import com.example.demo.data.statistic.utils.CollectionUtil;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class JdbcDataRepository implements DataRepository {

    @Resource
    private DataOptionMapper dataOptionMapper;
    @Resource
    private ResourceDataMapper resourceDataMapper;

    private Cache<String, DataOption> optionCache = Caffeine.newBuilder().expireAfterWrite(1, TimeUnit.HOURS).build();

    @Override
    public DataOption findOption(String key) {

        DataOption option = optionCache.getIfPresent(key);
        if (option == null) {
            option = dataOptionMapper.selectOneByKey(key);
            optionCache.put(key, option);
        }
        return option;
    }

    @Override
    public LocalDateTime findResourceBeginDate(String resourceType, String dataType, String timeType) {
        return resourceDataMapper.selectMaxEndDate(resourceType, dataType, timeType);
    }

    @Override
    public void saveResourceData(List<ResourceData> dataList) {
        if (CollectionUtil.isEmpty(dataList)) {
            return;
        }
        resourceDataMapper.insertList(dataList);
    }
}
