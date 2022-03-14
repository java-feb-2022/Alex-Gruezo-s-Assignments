package com.alex.bookClub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.alex.bookClub.models.Book;
import com.alex.bookClub.models.LoginUser;
import com.alex.bookClub.models.User;
import com.alex.bookClub.services.BookService;
import com.alex.bookClub.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;

	@GetMapping("/")
	public String index(
			@ModelAttribute("newUser") User user,
			@ModelAttribute("newLogin") LoginUser loginUser) {
		
		return "index.jsp";
	}
	
//****** REGISTER USER ******//
	
	@PostMapping("/register")
	public String register(
			@Valid @ModelAttribute("newUser") User user,
			BindingResult result,
			HttpSession session,
			@ModelAttribute("newLogin") LoginUser loginUser) {
		
		// validate user
		userService.validate(user, result);
		if(result.hasErrors()) {
			return "index.jsp";
		}
		
		// register user
		userService.registerUser(user);
		
		// put user in session
		session.setAttribute("loggedInUser", user);
		return "redirect:/books";
		
	}

//****** LOGIN USER ******//
	
	@PostMapping("/login")
	public String login(
			@Valid @ModelAttribute("newLogin") LoginUser loginUser,
			BindingResult result,
			HttpSession session,
			@ModelAttribute("newUser") User user) {
		
		// authenticate user
		userService.authenticateUser(loginUser, result);
		if(result.hasErrors()) {
			return "index.jsp";
		}
		
		User loggedInUser = userService.findByEmail(loginUser.getUserEmail());
		
		// put user in session
		session.setAttribute("loggedInUser", loggedInUser);
		return "redirect:/books";
	}
	
//****** LOGOUT ******//
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "redirect:/";
	}
	
//****** DASHBOARD ******//
	
	@GetMapping("/books")
	public String dashboard(
			Model viewModel,
			HttpSession session) {
		
		if(session.getAttribute("loggedInUser") != null) {
			
			//System.out.println(session.getAttribute("loggedInUser"));
			viewModel.addAttribute("books", bookService.getAllBooks()); 
			return "dashboard.jsp";
		} else {
			return "redirect:/";
		}
	}
	
	@GetMapping("/books/new")
	public String newBook(
			@ModelAttribute("newBook") Book book,
			HttpSession session) {
		
		if(session.getAttribute("loggedInUser") != null) {
			return "newBook.jsp";
		} else {
			return "redirect:/";
		}
	}
	
	@PostMapping("/books/create")
	public String createBook(
			@Valid @ModelAttribute("newBook") Book book,
			BindingResult result,
			HttpSession session) {
		
		if(result.hasErrors()) {
			return "newBook.jsp";
		}
		
		bookService.create(book);
		return "redirect:/books";
		
	}
	
	@GetMapping("/books/{id}")
	public String showBook(
			@PathVariable("id") Long id,
			Model viewModel,
			HttpSession session) {
		
		if(session.getAttribute("loggedInUser") != null) {
			
			Book book = bookService.showOne(id);
			viewModel.addAttribute("book", book);
			viewModel.addAttribute("user", userService.findByEmail("loggedInUser"));
			
			return "showBook.jsp";
		} else {
			return "redirect:/";
		}
	}
	
	@GetMapping("/books/{id}/edit")
	public String editBook(
			@PathVariable("id") Long id,
			Model viewModel,
			HttpSession session) {
		
		if(session.getAttribute("loggedInUser") != null) {
			
			Book book = bookService.showOne(id);
			
			viewModel.addAttribute("editBook", book);
			return "editBook.jsp";
		} else {
			
			return "redirect:/";
		}
	}
	
	@PutMapping("/books/{id}/update")
	public String updateBook(
			@PathVariable ("id") Long id,
			@Valid @ModelAttribute("editBook") Book book,
			BindingResult result,
			Model viewModel) {
		
		
		if(result.hasErrors()) {
			
			return "editBook.jsp";
		} 
			
		bookService.update(book);
		return "redirect:/books";
	}
		 
	
			
}
