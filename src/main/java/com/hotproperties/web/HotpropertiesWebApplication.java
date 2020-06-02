package com.hotproperties.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.hotproperties.web")
@EnableAutoConfiguration()
public class HotpropertiesWebApplication{

	public static void main(String[] args) {
		SpringApplication.run(HotpropertiesWebApplication.class, args);
	}

}
