package com.example.demo.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Doctor")
@NamedQueries({
	@NamedQuery(
			name = "findByLocationAndSpeciality",
			query = "from Doctor u where u.location=:location and u.specialityCode=:specialityCode"
	)
})
public class Doctor {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
    @Column(name="firstname")
	private String firstname;
    @Column(name="lastname")
	private String lastname;
    @Column(name="specialityCode")
	private String specialityCode;
    @Column(name="location")
    private String location;
    
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getSpecialityCode() {
		return specialityCode;
	}
	public void setSpecialityCode(String specialityCode) {
		this.specialityCode = specialityCode;
	}
}
