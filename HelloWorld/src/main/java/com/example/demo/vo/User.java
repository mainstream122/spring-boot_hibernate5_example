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
@Table(name="User")
@NamedQueries({
	@NamedQuery(
			name = "findByEmail",
			query = "from User u where u.email=:email"
	)
})
public class User {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
