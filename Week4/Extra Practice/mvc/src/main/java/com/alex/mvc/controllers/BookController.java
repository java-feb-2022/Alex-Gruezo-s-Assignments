package com.alex.mvc.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.alex.mvc.models.Book;
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
	
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		
		return "new.jsp";
	}
	
	@PostMapping("/books/create")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		
		if (result.hasErrors()) {
			return "new.jsp";
		} else {
		
			bookService.createBook(book);
			return "redirect:/";
		}
	}
	
	@GetMapping("/books/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model viewModel) {
		
		Book book = bookService.findBook(id);
		viewModel.addAttribute("book", book);
		
		return "edit.jsp";
		
	}
	
	@PutMapping("/books/{id}/update")
	public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			bookService.updateBook(book);
			return "redirect:/";
		}
		
	}
	
	@DeleteMapping("/books/{id}/delete")
	public String destroy(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
		return "redirect:/";
	}
}
