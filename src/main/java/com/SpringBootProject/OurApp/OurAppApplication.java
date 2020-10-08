package com.SpringBootProject.OurApp;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OurAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(OurAppApplication.class, args);
	}

	@Bean
	LayoutDialect thymeleafDialect(){
		return new LayoutDialect();
	}


}
