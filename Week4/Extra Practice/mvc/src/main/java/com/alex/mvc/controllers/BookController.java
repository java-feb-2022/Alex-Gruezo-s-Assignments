package com.alex.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.alex.mvc.services.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/")
	public String index() {
		
		return "redirect:/books";
	}
	
	@GetMapping("/books")
	public String allBooks(Model viewModel) {
		
		viewModel.addAttribute("books", bookService.allBooks());
		
//		System.out.println(bookService.allBooks());
		return "index.jsp";
	}
	
	@GetMapping("/books/{id}")
	public String getOne(@PathVariable("id") Long id, Model viewModel) {
		
		viewModel.addAttribute("book", bookService.findBook(id));
		
		return "show.jsp";
	}
}
