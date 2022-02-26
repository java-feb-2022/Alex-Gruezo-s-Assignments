package com.alex.omikujiForm.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmikujiController {
	
	@GetMapping("/") 
	public String index() {
		return "redirect:/omikuji";
	}
	
	@GetMapping("/omikuji")
	public String form() {
		return "form.jsp";
	}
	
	@PostMapping("/submit")
	public String submit(HttpSession session,
			@RequestParam int number,
			@RequestParam String city,
			@RequestParam String name,
			@RequestParam String hobby,
			@RequestParam String livingThing,
			@RequestParam String quote) {
		
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("name", name);
		session.setAttribute("hobby", hobby);
		session.setAttribute("livingThing", livingThing);
		session.setAttribute("quote", quote);
		
		return "redirect:/omikuji/show";

	}
	
	@GetMapping("/omikuji/show")
		public String show(HttpSession session, Model viewModel) {
		
			int number = (Integer)session.getAttribute("number");
			String city = (String)session.getAttribute("city");
			String name = (String) session.getAttribute("name");
			String hobby = (String) session.getAttribute("hobby");
			String livingThing = (String) session.getAttribute("livingThing");
			String quote = (String) session.getAttribute("quote");
		
		
			viewModel.addAttribute("number", number);
			viewModel.addAttribute("city", city);
			viewModel.addAttribute("name", name);
			viewModel.addAttribute("hobby", hobby);
			viewModel.addAttribute("livingThing", livingThing);
			viewModel.addAttribute("quote", quote);
			
		
			return "show.jsp";
		}
	
}
