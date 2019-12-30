package com.ijson.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;

@EnableCaching
@SpringBootApplication
@ImportResource(locations = {"classpath:applicationContext.xml"})
public class Bootstrap {

	public static void main(String[] args) {
		System.setProperty("config.enableZookeeper", "false");
		SpringApplication.run(Bootstrap.class, args);
	}

}
