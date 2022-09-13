//package com.demo.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.demo.clients.BooksStoreClient;
//import com.demo.models.Book;
//
//@RestController
//@RequestMapping("api/v1/author")
//public class KafkaAuthorController {
//	
//	@Autowired
//	private KafkaTemplate<?, Book> kafkaTemplate;
//	
//	@Autowired
//	private BooksStoreClient client;
//	
//	private static final String TOPIC = "kafka-topic";
//
//	@PutMapping("/kafka/{authorId}/books/{bookId}")
//	public Book updateBook(@PathVariable int authorId, @PathVariable int bookId, @RequestBody Book book) {
//		System.out.println("Edit/Block-unblock a book in books store");
//		Book updateBook = client.updateBook(bookId, authorId, book);
//		if(updateBook != null && !updateBook.isActive())
//			kafkaTemplate.send(TOPIC, updateBook);
//		
//		return updateBook;
//	}
//	
//}
