package com.project.moviecentralapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MovieCentralApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieCentralApiApplication.class, args);
	}

}
