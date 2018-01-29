package com.example.demo.common;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.example.demo.service.UserService;
import com.example.demo.vo.User;

@Component
@Lazy
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserService userService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		
		User user = null;
		try {
			user = userService.doesUserExist(username);
		} catch (UserNotFoundException e) {
		}
		
		if (user == null || !user.getEmail().equalsIgnoreCase(username)) {
			throw new BadCredentialsException("Username not found.");
		}
		
		if (!password.equals(user.getPassword())) {
			throw new BadCredentialsException("Wrong password.");
		}
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		if (user.getAuth().equals(UserAuthorities.ADMIN.toString())) {
			authorities.add(new SimpleGrantedAuthority(UserAuthorities.ADMIN.toString()));
		} else if (user.getAuth().equals(UserAuthorities.MEMBER.toString())) {
			authorities.add(new SimpleGrantedAuthority(UserAuthorities.MEMBER.toString()));
		}
		
		return new UsernamePasswordAuthenticationToken(user, password, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
