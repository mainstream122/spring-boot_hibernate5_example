package com.example.demo.vo;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.common.UserAuthorities;


@Entity
@Table(name="User")
@NamedQueries({
	@NamedQuery(
			name = "findByEmail",
			query = "from User u where u.email=:email"
	)
})
public class User implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2487891564260637230L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="auth")
	private String auth;
	@Column(name="nickname")
	private String nickname;
	
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
	@Override
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection <GrantedAuthority> grantedAuth = new ArrayList<>();
		if (getAuth().equals(UserAuthorities.ADMIN.toString())) {
			grantedAuth.add(new SimpleGrantedAuthority(UserAuthorities.ADMIN.toString()));
		} else if (getAuth().equals(UserAuthorities.MEMBER.toString())) {
			grantedAuth.add(new SimpleGrantedAuthority(UserAuthorities.MEMBER.toString()));
		};
		return grantedAuth;
	}
	@Override
	public String getUsername() {
		return getEmail();
	}
	@Override
	public boolean isAccountNonExpired() {
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}
	@Override
	public boolean isEnabled() {
		return false;
	}
}
