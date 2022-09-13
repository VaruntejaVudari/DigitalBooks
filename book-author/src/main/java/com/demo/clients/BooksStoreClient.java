package com.demo.clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.demo.models.Book;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

//@FeignClient(value = "comic", url = "http://localhost:9090/api/v1/books")
@FeignClient("book-library")
public interface BooksStoreClient {
	
	@PostMapping("/api/v1/books")
	Book saveBook(@RequestBody Book b);
	
	@PutMapping("/api/v1/books/{id}/author/{authorId}")
	Book updateBook(@PathVariable int id, @PathVariable int authorId, @RequestBody Book b);
}
