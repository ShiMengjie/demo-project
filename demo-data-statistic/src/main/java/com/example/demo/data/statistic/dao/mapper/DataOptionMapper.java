package com.example.demo.data.statistic.dao.mapper;

import com.example.demo.data.statistic.po.DataOption;
import org.apache.ibatis.annotations.Param;

public interface DataOptionMapper {

    /**
     * 根据 key 值查询记录，key 是唯一索引
     */
    DataOption selectOneByKey(@Param("key") String key);
}
