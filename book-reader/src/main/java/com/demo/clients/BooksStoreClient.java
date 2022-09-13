package com.demo.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.models.Book;

//@FeignClient(value = "comic", url = "http://localhost:9090/api/v1/books")
@FeignClient("book-library")
public interface BooksStoreClient {
	
	@GetMapping("/api/v1/books")
    List<Book> getBooks();

    @GetMapping("/api/v1/books/{id}")
    Book getBookById(@PathVariable int id);
    
    @GetMapping("/api/v1/books/title")
    List<Book> getBookByTitle(@RequestParam String title);
    
    @GetMapping("/api/v1/books/price/{price}")
    List<Book> getBookByPrice(@PathVariable Long price);
    
    @GetMapping("/api/v1/books/search")
    List<Book> getBookByFilter(@RequestParam String title, @RequestParam String category, 
			@RequestParam Long price, @RequestParam String releasedDate, @RequestParam String publisher);
    
    @GetMapping("/api/v1/books/list-all")
    public List<Book> findBooksByIds(@RequestParam String bookIds);
}
