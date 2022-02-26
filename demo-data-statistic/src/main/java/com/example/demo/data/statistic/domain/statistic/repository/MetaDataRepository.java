package com.example.demo.data.statistic.domain.statistic.repository;

import java.time.LocalDateTime;

public interface MetaDataRepository {

    /**
     * 计算资源的 PV
     *
     * @param resourceType 资源类型
     * @param startDate    统计的开始时间，>= startAt
     * @param endDate      统计的截止时间，< endAt
     */
    int countResourcePV(String resourceType, LocalDateTime startDate, LocalDateTime endDate);

    /**
     * 计算资源的 UV
     *
     * @param resourceType 资源类型
     * @param startDate    统计的开始时间，>= startAt
     * @param endDate      统计的截止时间，< endAt
     */
    int countResourceUV(String resourceType, LocalDateTime startDate, LocalDateTime endDate);
}
