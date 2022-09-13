package com.demo.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Author;
import com.demo.repositories.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository repo;

	// subscribed for books by bookid and email
	public Author save(Author r) {
		return repo.save(r);
	}

	// unsubscribed for books by bookid and email
	public Author unSubscribeBook(String email, int bookId) {
		Optional<Author> reader = repo.findById(bookId);
		if(reader != null) {
			return repo.save(reader.get());
		}
		else {
			System.out.println("Reader with Book id ("+bookId+") not found in db");
		}
		return reader.get();
	}

}
