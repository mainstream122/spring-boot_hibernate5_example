package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.common.CustomAuthenticationFilter;
import com.example.demo.common.CustomAuthenticationProvider;
import com.example.demo.common.XSRFTokenFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationEntryPoint authenticationEntryPoint;
	
	@Autowired
	private CustomAuthenticationProvider authenticationProvider;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider);
	}
	
	@Bean
	CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
		CustomAuthenticationFilter filter = new CustomAuthenticationFilter();
		filter.setAuthenticationManager(authenticationManagerBean());
		filter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/account/login", "POST"));
		return filter;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
		http.authorizeRequests()
			.antMatchers("/doctors/**", "/account/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.addFilterAfter(new XSRFTokenFilter(), CsrfFilter.class)
			.csrf()
			.csrfTokenRepository(csrfTokenRepository());
		http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
	}
	
	private CsrfTokenRepository csrfTokenRepository() {
		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		repository.setHeaderName("X-XSRF-TOKEN");
		return repository;
	}
}
