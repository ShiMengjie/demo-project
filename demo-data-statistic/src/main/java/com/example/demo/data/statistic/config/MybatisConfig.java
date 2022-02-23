package com.example.demo.data.statistic.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.demo.data.statistic.dao.mapper")
public class MybatisConfig {

}
