package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.vo.Doctor;
@Repository
@Transactional
public class DoctorDAOImpl implements DoctorDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Doctor> findByLocationAndSpeciality(String location, String speciality) {
		System.out.println("LOCATION : " + location + ", SPECIALITY : " + speciality);
		Session session = sessionFactory.openSession();
		List<Doctor> result = session.getNamedQuery("findByLocationAndSpeciality")
									.setString("location", location)
									.setString("specialityCode", speciality)
									.list();
		session.close();
		return result;
	}

}
