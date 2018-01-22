package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DoctorDAO;
import com.example.demo.vo.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorDAO doctorDao;
	
	@Override
	public List<Doctor> findByLocationAndSpeciality(String location, String speciality) {
		// TODO Auto-generated method stub
		return doctorDao.findByLocationAndSpeciality(location, speciality);
	}

}
