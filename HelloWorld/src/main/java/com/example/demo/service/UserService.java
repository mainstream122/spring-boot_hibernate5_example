package com.example.demo.service;

import com.example.demo.common.UserNotFoundException;
import com.example.demo.vo.User;

public interface UserService {

	public User doesUserExist(String email) throws UserNotFoundException;
}
