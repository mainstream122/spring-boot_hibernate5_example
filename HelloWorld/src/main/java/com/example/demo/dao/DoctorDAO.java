package com.example.demo.dao;

import java.util.List;

import com.example.demo.vo.Doctor;

public interface DoctorDAO {
	public List<Doctor> findByLocationAndSpeciality(String location, String speciality);
}
