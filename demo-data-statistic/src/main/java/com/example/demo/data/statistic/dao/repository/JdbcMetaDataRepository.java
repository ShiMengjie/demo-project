package com.example.demo.data.statistic.dao.repository;

import com.example.demo.data.statistic.dao.mapper.MetaDataMapper;
import com.example.demo.data.statistic.domain.statistic.entity.valueobject.OperateEnum;
import com.example.demo.data.statistic.domain.statistic.repository.MetaDataRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Service
public class JdbcMetaDataRepository implements MetaDataRepository {

    @Resource
    private MetaDataMapper metaDataMapper;

    @Override
    public int countResourcePV(String resourceType, LocalDateTime startDate, LocalDateTime endDate) {
        return metaDataMapper.countResourcePV(resourceType, OperateEnum.VIEW_RESOURCE.getValue(), startDate, endDate);
    }

    @Override
    public int countResourceUV(String resourceType, LocalDateTime startDate, LocalDateTime endDate) {
        return metaDataMapper.countResourceUV(resourceType, OperateEnum.VIEW_RESOURCE.getValue(), startDate, endDate);
    }
}
