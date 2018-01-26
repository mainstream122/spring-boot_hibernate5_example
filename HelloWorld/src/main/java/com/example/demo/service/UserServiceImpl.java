package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.UserNotFoundException;
import com.example.demo.dao.UserDAO;
import com.example.demo.vo.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	
	@Autowired
	public UserServiceImpl(UserDAO userDAO) { 
		this.userDAO = userDAO;
	}
	
	@Override
	public User doesUserExist(String email) throws UserNotFoundException {
		List<User> users = (List<User>)userDAO.findByEmail(email);
		if (users.size()==0) {
			throw new UserNotFoundException("User does not exist int the database.");
		}
		return users.get(0);
	}

}
