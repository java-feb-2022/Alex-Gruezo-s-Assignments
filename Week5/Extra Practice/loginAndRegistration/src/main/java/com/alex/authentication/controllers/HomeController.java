package com.alex.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.alex.authentication.models.LoginUser;
import com.alex.authentication.models.User;
import com.alex.authentication.services.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String index(
			@ModelAttribute("newUser") User user, 
			@ModelAttribute("newLogin") LoginUser loginUser) {
		
		return "index.jsp";
	}
	
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
		return "redirect:/dashboard";
	}
	
	@PostMapping("/login")
	public String login(
			@ModelAttribute("newUser") User user,
			@Valid @ModelAttribute("newLogin") LoginUser loginUser, 
			BindingResult result,
			HttpSession session
			) {
		
		// authenticate user
		userService.authenticateUser(loginUser, result);
		if(result.hasErrors()) {
			return "index.jsp";
		}
		
		User loggedInUser = userService.findByEmail(loginUser.getEmail());
		// put user in session
		session.setAttribute("loggedInUser", loggedInUser);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/dashboard")
		public String dashboard(HttpSession session) {
			
		if(session.getAttribute("loggedInUser") != null) {
			return "dashboard.jsp";
		} else {
			return "redirect:/";
		}
		
	}
	
}
