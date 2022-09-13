//package com.demo.services;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//import com.demo.entities.Reader;
//import com.demo.models.Book;
//import com.demo.models.EmailDetails;
//
//@Service
//public class KafkaReaderService {
//
//	@Autowired
//	ReaderService service;
//	
//	@Autowired 
//	private EmailService emailService;
//	
//	@KafkaListener(
//			topics = "kafka-topic", 
//			groupId="group_id", 
//			containerFactory = "userKafkaListenerFactory"
//		)
//	public void sendBlockMails(Book book) {
//	    System.out.println("Consumed book:" + book);
//	    List<Reader> readersList =  service.getAllReadersByBookId(book.getId());
//	    for (Reader reader : readersList) {
//			System.out.println("Sending Mail to Reader ::"+reader.getEmail());
//			EmailDetails details = new EmailDetails();
//			details.setSubject("Book is Blocked");
//			details.setMsgBody("Hey! \n This is to inform you that your subscribed book wiht Id ["+reader.getBookId()+"] is currently blocked my author");
//			details.setRecipient(reader.getEmail());
//			emailService.sendSimpleMail(details);
//		}
//	}
//	
//}
