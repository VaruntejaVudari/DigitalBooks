package com.demo.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Book;
import com.demo.exceptions.BookNotFoundException;
import com.demo.helper.BookHelper;
import com.demo.services.BookService;

@RestController
//@CrossOrigin(origins = {"https://hoppscotch.io", "http://localhost:4200"})
//@CrossOrigin(origins = {"*"})
@CrossOrigin
@RequestMapping("/api/v1/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("")
	public List<Book> getBooks() {
		return bookService.findAllBooks();
	}
	
	@GetMapping("/{id}")
	public Book findBookById(@PathVariable int id) throws BookNotFoundException {
		return bookService.findBookById(id);
	}
	
	@GetMapping("/title")
	public List<Book> findBooksByTitle(@RequestParam String title) {
		return bookService.findBooksByTitle(title);
	}

	@GetMapping("/price/{price}")
	public List<Book> findBooksByPrice(@PathVariable Long price) {
		return bookService.findBooksByPrice(price);
	}
	
	@GetMapping("/search")
	public List<Book> getBooksList(@RequestParam Optional<String> title, @RequestParam Optional<String> category, 
			@RequestParam Optional<Long> price, @RequestParam Optional<String> releasedDate, @RequestParam Optional<String> publisher) {
		BookHelper b = new BookHelper();
		b.setTitle(title.isPresent()?title.get() : null);
		b.setCategory(category.isPresent()? category.get() : null);
		b.setPrice(price.isPresent()?price.get():null);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		if(releasedDate.isPresent()) {
			LocalDate dateTime = LocalDate.parse(releasedDate.get(), formatter);
			b.setReleasedDate(dateTime);
		}
		b.setPublisher(publisher.isPresent()?publisher.get():null);
		return bookService.findMatchingBooks(b);
	}
	
	@GetMapping("/list-all")
	public List<Book> findBooksByIds(@RequestParam String bookIds) throws BookNotFoundException {
		List<Integer> bookIdList = new ArrayList<Integer>();
		for(String book : bookIds.split(",")) {
			bookIdList.add(Integer.parseInt(book));
		}
		return bookService.findAllBookByIds(bookIdList);
	}
	
	@PostMapping("")
	public Book saveBook(@RequestBody Book b) {
		return bookService.saveBook(b);
	}
	
	@DeleteMapping("/{id}")
	public void deleteBookById(@PathVariable int id) throws BookNotFoundException {
		bookService.deleteBook(id);
	}
	
	@PutMapping("/{id}/author/{authorId}")
	public Book updateBook(@PathVariable int id, @PathVariable int authorId, @RequestBody Book b) throws BookNotFoundException {
		return bookService.updateBook(id, authorId, b);
	}
	
	
}
