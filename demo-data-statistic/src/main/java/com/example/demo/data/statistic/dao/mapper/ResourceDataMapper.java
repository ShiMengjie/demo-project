package com.example.demo.data.statistic.dao.mapper;

import com.example.demo.data.statistic.po.ResourceData;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ResourceDataMapper {

    /**
     * 批量插入
     */
    void insertList(List<ResourceData> dataList);

    /**
     * 查询本次统计的开始时间
     *
     * @param resourceType 资源类型
     * @param dataType     统计数据指标类型
     * @param timeType     时间类型
     * @return LocalDateTime
     */
    LocalDateTime selectMaxEndDate(@Param("resourceType") String resourceType, @Param("dataType") String dataType,
                                   @Param("timeType") String timeType);
}
