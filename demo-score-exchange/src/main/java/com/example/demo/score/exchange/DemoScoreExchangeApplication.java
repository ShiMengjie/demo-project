package com.example.demo.score.exchange;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Locale;

@Slf4j
@SpringBootApplication
public class DemoScoreExchangeApplication {

	public static void main(String[] args) {
		Locale.setDefault(Locale.SIMPLIFIED_CHINESE);
		ApplicationContext ctx = SpringApplication.run(DemoScoreExchangeApplication.class, args);
		Environment env = ctx.getEnvironment();
		String appName = env.getProperty("spring.application.name", "application");
		log.info("==== " + appName + " has been started ====");
	}

}
