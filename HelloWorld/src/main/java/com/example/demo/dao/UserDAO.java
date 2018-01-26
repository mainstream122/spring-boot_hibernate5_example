package com.example.demo.dao;

import java.util.List;

import com.example.demo.vo.User;

public interface UserDAO {

	public List<User> findByEmail(String email);
}
