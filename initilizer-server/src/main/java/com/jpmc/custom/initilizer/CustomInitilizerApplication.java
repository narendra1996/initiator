package com.jpmc.custom.initilizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Import(CustomInitializrConfiguration.class)
public class CustomInitilizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomInitilizerApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

}
