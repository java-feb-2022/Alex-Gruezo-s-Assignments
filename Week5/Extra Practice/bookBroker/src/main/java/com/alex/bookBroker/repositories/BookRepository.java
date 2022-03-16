package com.alex.bookBroker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alex.bookBroker.models.Book;



@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	
	List<Book> findAll();
	
	List<Book> findByBorrowerIsNull();
	
	List<Book> findByBorrowerIsNotNull();
	
	

}
