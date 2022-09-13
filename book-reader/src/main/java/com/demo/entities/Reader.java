package com.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//optional
	private int id;
	private String name;
	private String email;
	private int bookId;
	private boolean subscribed;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public boolean isSubscribed() {
		return subscribed;
	}
	public void setSubscribed(boolean subscribed) {
		this.subscribed = subscribed;
	}
	
	@Override
	public String toString() {
		return "Reader [id=" + id + ", name=" + name + ", email=" + email + ", bookId=" + bookId + ", subscribed="
				+ subscribed + "]";
	}
	
	public Reader(int id, String name, String email, int bookId, boolean subscribed) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.bookId = bookId;
		this.subscribed = subscribed;
	}
	public Reader() {
		super();
		// TODO Auto-generated constructor stub
	}
		
}
