package com.example.demo.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
@EnableAutoConfiguration(exclude = {JpaRepositoriesAutoConfiguration.class})
@SpringBootApplication(scanBasePackages= {"com.example.**"})
public class HelloWorldApplication extends WebMvcConfigurerAdapter {

	@RequestMapping("/")
	String home() {
		return "index";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}
}
