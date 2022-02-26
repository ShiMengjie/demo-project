package com.example.demo.data.statistic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Date;
import java.util.Locale;

@Slf4j
@EnableScheduling
@SpringBootApplication
public class DemoDataStatisticApplication {

    public static void main(String[] args) {
        Locale.setDefault(Locale.SIMPLIFIED_CHINESE);
        ApplicationContext ctx = SpringApplication.run(DemoDataStatisticApplication.class, args);
        Environment env = ctx.getEnvironment();
        String appName = env.getProperty("spring.application.name", "application");
        log.info("==== " + appName + " has been started ====");
    }

}
