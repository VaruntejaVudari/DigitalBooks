package com.demo.models;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Book {
	
	private int id;
	private String title;
	private String publisher;
	private String category;
	private Long price;
	private LocalDate releasedDate = LocalDate.now();
	private boolean active = true;
	private String content;
	private int authorId;
	
	@JsonIgnore
	private List<Integer> bookIds;
	
	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public List<Integer> getBookIds() {
		return bookIds;
	}

	public void setBookIds(List<Integer> bookIds) {
		this.bookIds = bookIds;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public LocalDate getReleasedDate() {
		return releasedDate;
	}

	public void setReleasedDate(LocalDate releasedDate) {
		this.releasedDate = releasedDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Book(int id, String title, String publisher, String category, Long price, LocalDate releasedDate,
		boolean active, String content, int authorId, List<Integer> bookIds) {
		super();
		this.id = id;
		this.title = title;
		this.publisher = publisher;
		this.category = category;
		this.price = price;
		this.releasedDate = releasedDate;
		this.active = active;
		this.content = content;
		this.authorId = authorId;
		this.bookIds = bookIds;
	}

	public Book(String title, String publisher, String category, Long price, LocalDate releasedDate,
			boolean active, String content, int authorId, List<Integer> bookIds) {
			super();
			this.title = title;
			this.publisher = publisher;
			this.category = category;
			this.price = price;
			this.releasedDate = releasedDate;
			this.active = active;
			this.content = content;
			this.authorId = authorId;
			this.bookIds = bookIds;
		}
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", publisher=" + publisher + ", category=" + category
				+ ", price=" + price + ", releasedDate=" + releasedDate + ", active=" + active + ", content=" + content
				+ ", authorId=" + authorId + ", bookIds=" + bookIds + "]";
	}

}
