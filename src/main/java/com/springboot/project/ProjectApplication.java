package com.springboot.project;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectApplication {

	private static Logger logger = LoggerFactory.getLogger(ProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);


		logger.debug("Mi mensaje debug");
		logger.trace("Mi mensaje trace");
//		logger.info("Mi mensaje info");
//		logger.warn("Mi mensaje warn");
//		logger.error("Mi mensaje error");

	}
}
