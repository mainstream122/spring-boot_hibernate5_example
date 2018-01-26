package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.vo.User;

@Controller
@RequestMapping("/account/*")
public class UserAccountController {

	@Autowired
	AuthenticationProvider authenticationProvider;
	
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
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String processLogin(User reqUser, HttpServletRequest request, HttpSession session) {
		Authentication authentication = null;
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(reqUser.getEmail(), reqUser.getPassword());
		try {
			authentication = this.authenticationProvider.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			//User user = (User) authentication.getPrincipal();
			//user.setPassword(null);
			return "index";
		} catch (Exception e) {
			return "error"; 
		}
	}
}
