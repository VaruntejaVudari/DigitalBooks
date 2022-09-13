package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.entities.Book;
import com.demo.services.BookService;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private BookService service;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Service:"+service);

//		service.saveBook(new Book("Java1", "xyz", "DSA",100L,"JAva Developer"));
//		service.saveBook(new Book("ADV JAVA", "djsd", "DVE",200L,"Dewald Brewis"));
//		service.saveBook(new Book("PYTHN", "abc", "Programming",300L,"Coding MAkes Less"));
//		service.saveBook(new Book("SELENIUM", "sdewd", "Junit",400L,"AUtomation "));
//		service.saveBook(new Book("SQL", "abhi", "Programming",500L,"Database"));

	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
