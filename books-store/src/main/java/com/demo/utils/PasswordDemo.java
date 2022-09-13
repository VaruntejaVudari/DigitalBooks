package com.demo.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordDemo {
	public static void main(String[] args) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println("reader@123: "+encoder.encode("reader@123"));
		System.out.println("author@123: "+encoder.encode("author@123"));
	}
}
