package com.alex.counter.controllers;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		
		if (session.getAttribute("count") == null) {
		session.setAttribute("count", 0);
		
	} else {
		
		Integer counter = (Integer) session.getAttribute("count");
		counter ++;
		
		session.setAttribute("count", counter);
	}
		return "index.jsp";
	}
		
	@RequestMapping("/counter")
	public String showCount(HttpSession session, Model viewModel) 	{
		
		Integer currentCount = (Integer) session.getAttribute("count");
		
		viewModel.addAttribute("currentCount", currentCount);
		
		return "counter.jsp";
	}
	
	@RequestMapping("/counter2x")
	public String doubleCount(HttpSession session, Model viewModel) 	{
		
		Integer currentCount = ((Integer) session.getAttribute("count"))*2;
		
		viewModel.addAttribute("currentCount", currentCount);
		
		return "counterDouble.jsp";
	}
	
	@RequestMapping("/clear_session")
	public String clearSession(HttpSession session) {
		
		session.setAttribute("count", 0);
		
		return "index.jsp";
	}

}
