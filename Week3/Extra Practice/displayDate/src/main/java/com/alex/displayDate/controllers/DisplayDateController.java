package com.alex.displayDate.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DisplayDateController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model viewModel) {
		
		String patternDayInWeek = "EEEE";
		String patternDayInMonth = "d";
		String patternMonth = "MMMM";
		String patternYear ="y";
		
		SimpleDateFormat dayInWeek = new SimpleDateFormat(patternDayInWeek);
		SimpleDateFormat dayInMonth = new SimpleDateFormat(patternDayInMonth);
		SimpleDateFormat monthInYear = new SimpleDateFormat(patternMonth);
		SimpleDateFormat inYear = new SimpleDateFormat(patternYear);
		
		String week = dayInWeek.format(new Date());
		String day = dayInMonth.format(new Date());
		String month = monthInYear.format(new Date());
		String year = inYear.format(new Date());
		
		viewModel.addAttribute("day", day);
		viewModel.addAttribute("week", week);
		viewModel.addAttribute("month", month);
		viewModel.addAttribute("year", year);
		
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model viewModel) {
		
		String pattern = "h:mm a";
		
		SimpleDateFormat timeOfDay = new SimpleDateFormat(pattern);
		
		String time = timeOfDay.format(new Date());
		viewModel.addAttribute("time", time);
		return "time.jsp";
	}
}
