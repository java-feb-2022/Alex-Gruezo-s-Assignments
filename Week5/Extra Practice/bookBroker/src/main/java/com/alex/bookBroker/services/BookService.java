package com.alex.bookBroker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.bookBroker.models.Book;
import com.alex.bookBroker.repositories.BookRepository;
import com.alex.bookBroker.repositories.UserRepository;

@Service
public class BookService {
	
	@Autowired
	public BookRepository bookRepository;
	
	@Autowired
	public UserRepository userRepository;

	public List<Book> getAllBooks() {
		
		return bookRepository.findAll();
	}
	
	public List<Book> getBorrowedBooks() {
		
		return bookRepository.findByBorrowerIsNotNull();
	}
	
	public List<Book> getUnborrowedBooks() {
		
		return bookRepository.findByBorrowerIsNull();
	}
	
	public Book showOne(Long id) {
		
		return bookRepository.findById(id).orElse(null);
	}
	
	public Book create(Book book) {
		
		return bookRepository.save(book);
	}
	
	public Book update(Book book) {
		
		return bookRepository.save(book);
	}
	
	public void delete(Long id) {
		
		bookRepository.deleteById(id);
	}
	
	
}
