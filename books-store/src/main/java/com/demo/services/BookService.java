package com.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Book;
import com.demo.exceptions.BookNotFoundException;
import com.demo.helper.BookHelper;
import com.demo.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repo;

	// save book
	public Book saveBook(Book b) {
		// validations - book title and author is not empty
		return repo.save(b);
	}

	// find all books
	public List<Book> findAllBooks() {
		return repo.findAll();
	}

	// find book by id
	public Book findBookById(int id) throws BookNotFoundException {
		Optional<Book> optionalBook = repo.findByIdandIsActive(id);

		if(optionalBook.isEmpty()) {
			throw new BookNotFoundException("Book with id ("+id+") not found in db or book is blocked");
		} else {
			return optionalBook.get();
		}
	}


	// find books by price
	public List<Book> findBooksByPrice(Long price) {
		if(price != null) {
			return repo.findByPriceGreaterThen(price);	
		}
		else {
			return findAllBooks();
		}
	}

	// find books by title
	public List<Book> findBooksByTitle(String title) {
		if(title != null && title.length() != 0) {
			return repo.findByTitle(title);	
		}
		else {
			return findAllBooks();
		}
	}

	// find books by book filter
	public List<Book> findMatchingBooks(BookHelper bookFilter) {
		return repo.findAll(bookFilter.getTitle(),bookFilter.getPublisher(),bookFilter.getCategory(),bookFilter.getPrice(),bookFilter.getReleasedDate());
	}

	// delete book by id
	public void deleteBook(int id) throws BookNotFoundException {
		Optional<Book> optionalBook = repo.findById(id);

		if(optionalBook.isEmpty()) {
			throw new BookNotFoundException("Book with ("+id+") id not found in db");
		} else {
			repo.deleteById(id);
		}
	}

	// update book 
	public Book updateBook(int id,int authorId, Book b) throws BookNotFoundException {
		Book oldBook = repo.findByIdAndAuthorId(id, authorId);
		if(oldBook != null) {
			oldBook.setTitle(b.getTitle() != null ? b.getTitle() : oldBook.getTitle());
			oldBook.setPublisher(b.getPublisher() != null ? b.getPublisher() : oldBook.getPublisher());
			oldBook.setCategory(b.getCategory() != null ? b.getCategory() : oldBook.getCategory());
			oldBook.setPrice(b.getPrice() != null ? b.getPrice() : oldBook.getPrice());
			oldBook.setContent(b.getContent() != null ? b.getContent() : oldBook.getContent());
			oldBook.setReleasedDate(b.getReleasedDate() != null ? b.getReleasedDate() : oldBook.getReleasedDate());
			oldBook.setActive(b.isActive());
			return saveBook(oldBook);
		} else {
			System.out.println("Book with id ("+id+") not found in db");
			throw new BookNotFoundException("Book with ("+id+") id not found in db");
		}
	}

	// find all books by book ids
	public List<Book> findAllBookByIds(List<Integer> bookIds) throws BookNotFoundException {
		List<Book> booksList = repo.findByIdIn(bookIds);
		if(booksList == null) {
			throw new BookNotFoundException("Books with given book ids not found in db or book is blocked");
		} else {
			return booksList;
		}
	}

}
