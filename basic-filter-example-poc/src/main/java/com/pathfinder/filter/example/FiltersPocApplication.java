package com.pathfinder.filter.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class FiltersPocApplication{

	public static void main(String[] args) {
		SpringApplication.run(FiltersPocApplication.class,args);
	}

}
