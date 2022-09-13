package com.demo.clients;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.models.Reader;


//@FeignClient(value = "comic", url = "http://localhost:9090/api/v1/reader")
@FeignClient("book-reader")
public interface BookReaderClient {
	
	@GetMapping("/api/v1/reader/allreaders")
	List<Reader> getAllReadersByBookId(@RequestParam int bookId);
}
