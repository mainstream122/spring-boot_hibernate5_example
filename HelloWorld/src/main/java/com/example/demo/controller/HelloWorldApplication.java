package com.example.demo.controller;

import java.security.Principal;

import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.demo.vo.User;

@SpringBootApplication(scanBasePackages= {"com.example.**"})
@Controller
@EnableAutoConfiguration(exclude = {JpaRepositoriesAutoConfiguration.class})
public class HelloWorldApplication extends WebMvcConfigurerAdapter {

	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		User current = null;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth.getPrincipal().getClass().equals(User.class)) {
			current = (User)auth.getPrincipal();
			System.out.println("PRINCIPAL IS NOT NULL!!");
		} else {
			current = new User();
			current.setAuth(auth.getAuthorities().toArray()[0].toString());
		}
		mav.addObject("user", current);
		mav.setViewName("index");
		return mav;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}
}
