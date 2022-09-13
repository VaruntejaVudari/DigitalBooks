package com.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.entities.Reader;

public interface ReaderRepository extends JpaRepository<Reader, Integer> {
	
	@Query(nativeQuery = false , value = "Select r from Reader r where r.bookId = ?1 and r.email = ?2 and r.subscribed = true")
	Reader findByBookIdandEmailandIsSubscribed(int bookId,String email);
	
	@Query(nativeQuery = false , value = "Select r from Reader r where r.bookId = ?1 and r.email = ?2")
	Reader findByBookIdandEmail(int bookId, String email);
	
	@Query(nativeQuery = false , value = "Select r from Reader r where r.email = ?1 and r.subscribed = true")
	List<Reader> findAllByEmailId(String email);
	
	@Query(nativeQuery = false , value = "Select r from Reader r where r.bookId = ?1 and r.subscribed = true")
	List<Reader> findByBookIdandIsSubscribed(int bookId);
}