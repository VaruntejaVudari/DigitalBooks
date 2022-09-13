package com.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.clients.BooksStoreClient;
import com.demo.entities.Reader;
import com.demo.models.Book;
import com.demo.services.ReaderService;

@RestController
@RequestMapping("api/v1/reader")
public class ReaderController {

	@Autowired
	private BooksStoreClient client;
	
	@Autowired ReaderService service;

	@GetMapping
	public List<Book> getDefaultBooks(){
		List<Book> shows = Arrays.asList(
				new Book("Java1", "abc", "Programming",100L,LocalDate.now(),true,"Introduction to Java",new ArrayList<>()),
				new Book("Java1", "abc", "Programming",100L,LocalDate.now(),true,"Introduction to Java",new ArrayList<>()));
		return shows;
	}

	@GetMapping("/books")
	public List<Book> getAllBooks() {		
		System.out.println("Fetching all books from books store");
		List<Book> books = client.getBooks();
		return books;
	}
	
	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable int id) {		
		System.out.println("Fetching book by id from books store");
		Book books = client.getBookById(id);
		return books;
	}
	
	@GetMapping("/books/title")
	public List<Book> getBookByTitle(@RequestParam String title) {		
		System.out.println("Fetching book by title from books store");
		List<Book> books = client.getBookByTitle(title);
		return books;
	}
	
	@GetMapping("/books/price/{price}")
	public List<Book> getBookByPrice(@PathVariable Long price) {		
		System.out.println("Fetching book by price from books store");
		List<Book> books = client.getBookByPrice(price);
		return books;
	}
	
	@GetMapping("/books/search")
	public List<Book> getAllBooksByFilter(@RequestParam(required = false) String title, @RequestParam(required = false) String category, 
			@RequestParam(required = false) Long price, @RequestParam(required = false) String releasedDate, @RequestParam(required = false) String publisher) {		
		System.out.println("Fetching all books by optional values from books store");
		List<Book> books = client.getBookByFilter(title,category,price,releasedDate,publisher);
		return books;
	}
	
	@PostMapping("/books/buy")
	public Reader subscribeBook(@RequestBody Reader reader) {
		return service.save(reader);
		
	}
	
	@PutMapping("/{emailId}/books/{bookId}/refund")
	public Reader unSubscribeBook(@PathVariable String emailId, @PathVariable int bookId) {
		return service.unSubscribeBook(emailId, bookId);
		
	}
	
	@GetMapping("/books/all-id")
	public List<Book> getAllBooksByIds(@RequestParam String bookIds) {
		return client.findBooksByIds(bookIds);
	}
	
	@GetMapping("/{emailId}/books")
	public List<Book> getAllPurchasedBook(@PathVariable String emailId) {	
		List<Reader> readersList = service.getAllSubscribers(emailId);
		String listId = readersList.stream().map(s -> s.getBookId()).map(String :: valueOf).collect(Collectors.joining(","));
		List<Book> listBooks = getAllBooksByIds(listId);
		return listBooks;
	}
	
	@GetMapping("/{emailId}/books/{bookId}")
	public Book readBook(@PathVariable String emailId, @PathVariable int bookId) {	
		Reader reader = service.getSubscribers(emailId,bookId);
		Book readBook = null;
		if(reader != null) {
			readBook = getBookById(bookId);
		}
		return readBook;
	}
	
	@GetMapping("/allreaders")
	public List<Reader> getAllReadersByBookId(@RequestParam int bookId){
		List<Reader> readersList = service.getAllReadersByBookId(bookId);
		return readersList;
	}
	
	
}