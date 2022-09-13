package com.demo.helper;

import java.time.LocalDate;
import java.util.List;

public class BookHelper {
	
	private String title;
	private String publisher;
	private String category;
	private Long price;
	private LocalDate releasedDate;
	private boolean active;
	private String content;
	private List<Integer> bookIds;
	
	public List<Integer> getBookIds() {
		return bookIds;
	}
	public void setBookIds(List<Integer> bookIds) {
		this.bookIds = bookIds;
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
	public LocalDate getReleasedDate() {
		return releasedDate;
	}
	public void setReleasedDate(LocalDate releasedDate) {
		this.releasedDate = releasedDate;
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
	
	@Override
	public String toString() {
		return "BookHelper [title=" + title + ", publisher=" + publisher + ", category=" + category + ", price=" + price
				+ ", releasedDate=" + releasedDate + ", active=" + active + ", content=" + content + ", bookIds="
				+ bookIds + "]";
	}
	
	public BookHelper(String title, String publisher, String category, Long price, LocalDate releasedDate,
			boolean active, String content, List<Integer> bookIds) {
		super();
		this.title = title;
		this.publisher = publisher;
		this.category = category;
		this.price = price;
		this.releasedDate = releasedDate;
		this.active = active;
		this.content = content;
		this.bookIds = bookIds;
	}
	public BookHelper() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
