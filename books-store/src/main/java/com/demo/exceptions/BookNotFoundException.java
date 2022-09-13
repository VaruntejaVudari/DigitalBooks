package com.demo.exceptions;

public class BookNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BookNotFoundException() {}

	public BookNotFoundException(String message) {
		super(message);
	}
	public BookNotFoundException(Exception e) {
		super(e);
	}
	public BookNotFoundException(String message, Exception e) {
		super(message, e);
	}
	
}
