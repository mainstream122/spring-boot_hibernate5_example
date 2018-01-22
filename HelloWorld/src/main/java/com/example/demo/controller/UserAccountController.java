package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/account/*")
public class UserAccountController {

	@RequestMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	@RequestMapping("/signup/process")
	public ModelAndView processSignup(ModelMap model, @RequestParam("nickname") String nickname, @RequestParam("emailaddress") String emailAddress, @RequestParam("password") String password) {
		model.addAttribute("login", true);
		model.addAttribute("nickname", nickname);
		model.addAttribute("message", "Have a greate day ahead.");
		return new ModelAndView("index", model);
	}
}
