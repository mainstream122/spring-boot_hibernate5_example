package com.example.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.vo.User;
@Repository
@Lazy
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<User> findByEmail(String email) {
		System.out.println("EMAIL : " + email);
		Session session = sessionFactory.openSession();
		List<User> result = session.getNamedQuery("findByEmail")
									.setString("email", email)
									.list();
		session.close();
		return result;
	}
}
