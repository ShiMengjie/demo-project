package com.example.demo.data.statistic.dao.mapper;

import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;

public interface MetaDataMapper {

    /**
     * 计算资源的 PV
     *
     * @param resourceType 资源类型
     * @param operate      行为
     * @param beginDate    开始时间
     * @param endDate      结束时间
     */
    int countResourcePV(@Param("resourceType") String resourceType, @Param("operate") String operate,
                        @Param("beginDate") LocalDateTime beginDate, @Param("endDate") LocalDateTime endDate);

    /**
     * 计算资源的 UV
     *
     * @param resourceType 资源类型
     * @param operate      行为
     * @param beginDate    开始时间
     * @param endDate      结束时间
     */
    int countResourceUV(@Param("resourceType") String resourceType, @Param("operate") String operate,
                        @Param("beginDate") LocalDateTime beginDate, @Param("endDate") LocalDateTime endDate);
}
