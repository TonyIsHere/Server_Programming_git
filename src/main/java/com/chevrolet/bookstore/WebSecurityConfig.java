package com.chevrolet.bookstore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//UserDetail
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;


import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login") 
		.defaultSuccessUrl("/booklist", true)
		.permitAll();
		//.loginPage --> redirect url if not auth
		//.defaultSuccessUrl --> if go on path /login and you're already
		//logged --> path to redirect
	}
	
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
	UserDetails user = User.withDefaultPasswordEncoder()
	.username("user")
	.password("Super123")
	.roles("USER")
	.build();
	
	UserDetails admin = User.withDefaultPasswordEncoder()
	.username("admin")
	.password("Super456")
	.roles("ADMIN")
	.build();
	
	List<UserDetails> users = new ArrayList();
	users.add(user);
	users.add(admin);
	return new InMemoryUserDetailsManager(users);
	}
}
