package com.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.clients.BookReaderClient;
import com.demo.clients.BooksStoreClient;
import com.demo.models.Book;
import com.demo.models.EmailDetails;
import com.demo.models.Reader;
import com.demo.services.AuthorService;
import com.demo.services.EmailService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/author")
public class AuthorController {

	@Autowired
	private BooksStoreClient client;
	
	@Autowired
	private BookReaderClient readerClient;
	
	@Autowired AuthorService service;
	
	@Autowired 
	private EmailService emailService;

	@GetMapping
	public List<Book> getDefaultBooks(){
		List<Book> shows = Arrays.asList(
				new Book("fafag", "ghzgag", "zgygzh",100L,LocalDate.now(),true,"gaghag to gzsgs",1,new ArrayList<>()),
				new Book("zhuhz", "azghgzhbc", "Programming",100L,LocalDate.now(),true,"ghgahah to gyagh",1,new ArrayList<>()));
		return shows;
	}

	@PostMapping("/{authorId}/books")
	public Book createBooks(@PathVariable int authorId, @RequestBody Book book) {		
		System.out.println("Creating a book in books store");
		book.setAuthorId(authorId);
		return client.saveBook(book);
	}
	
	@PutMapping("/{authorId}/books/{bookId}")
	public Book updateBook(@PathVariable int authorId, @PathVariable int bookId, @RequestBody Book book) {
		System.out.println("Edit/Block-unblock a book in books store");
		List<Reader> readersList = readerClient.getAllReadersByBookId(bookId);
		Book updateBook = client.updateBook(bookId, authorId, book);
		if(updateBook != null && !updateBook.isActive()) {
			for (Reader reader : readersList) {
				System.out.println("Readers ::"+reader.getEmail());
				EmailDetails details = new EmailDetails();
				details.setSubject("Book is Blocked");
				details.setMsgBody("Hey! \n This is to inform you that your subscribed book wiht Id ["+reader.getBookId()+"] is currently blocked my author");
				details.setRecipient(reader.getEmail());
				emailService.sendSimpleMail(details);
			}
		}
		return updateBook;
	}
	
}