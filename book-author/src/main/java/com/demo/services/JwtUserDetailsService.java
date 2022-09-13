package com.demo.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//find user from database
		if ("author".equals(username)) {
			Set<SimpleGrantedAuthority> authorities = new HashSet<>();
	        authorities.add(new SimpleGrantedAuthority("ROLE_" + "AUTHOR"));
			return new User("author", "$2a$10$Ou57ZyqxRq4DCc813FQNp.pTyrMIM1JewuPSY5.mPkjyICpQoyiLW", authorities);
		} else if ("reader".equals(username)) {
			return new User("reader", "$2a$10$yxLyRvPQGopgxzCL84j8X.srY6xh.jzKDNCdOB8pmXkP5SG7cnu3W", new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}
