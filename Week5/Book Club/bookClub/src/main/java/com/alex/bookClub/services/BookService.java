package com.alex.bookClub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.bookClub.models.Book;
import com.alex.bookClub.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBooks() {
		
		return bookRepository.findAll();
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
	
	public void delete(Book book) {
		
		bookRepository.delete(book);
	}
	
	

}
