package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Reader;
import com.demo.repositories.ReaderRepository;

@Service
public class ReaderService {

	@Autowired
	private ReaderRepository repo;

	// subscribed for books by bookid and email
	public Reader save(Reader r) {
		Reader reader = repo.findByBookIdandEmail(r.getBookId(),r.getEmail());
		if(reader != null && reader.isSubscribed()) {
			return reader;
		} else if(reader != null && !reader.isSubscribed()){
			reader.setSubscribed(true);
			return repo.save(reader);
		} else {
			r.setSubscribed(true);
			return repo.save(r);
		}
	}

	// unsubscribed for books by bookid and email
	public Reader unSubscribeBook(String email, int bookId) {
		Reader reader = repo.findByBookIdandEmailandIsSubscribed(bookId,email);
		if(reader != null) {
			reader.setSubscribed(false);
			return repo.save(reader);
		}
		else {
			System.out.println("Reader with Book id ("+bookId+") not found in db");
		}
		return reader;
	}

	//Get all subscribed readers by email
	public List<Reader> getAllSubscribers(String email) {
		List<Reader> readersList = repo.findAllByEmailId(email);
		return readersList;
	}

	//Get subscribed readers by email and bookId
	public Reader getSubscribers(String email, int bookId) {
		Reader reader = repo.findByBookIdandEmailandIsSubscribed(bookId,email);
		if(reader != null) {
			return reader;
		}
		else {
			System.out.println("Reader with Book id ("+bookId+") not found in db");
		}
		return reader;
	}
	
	// Get all readers by bood id
	public List<Reader> getAllReadersByBookId(int bookId){
		List<Reader> readersList = repo.findByBookIdandIsSubscribed(bookId);
		return readersList;
	}
}
