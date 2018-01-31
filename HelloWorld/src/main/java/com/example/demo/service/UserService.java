package com.example.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.common.UserNotFoundException;
import com.example.demo.vo.User;

public interface UserService extends UserDetailsService {

	public User doesUserExist(String email) throws UserNotFoundException;
}
