package com.alex.helloHuman.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
	@RequestMapping("/")
	public String index(@RequestParam(value = "firstName", required = false) String firstName,
			@RequestParam(value = "lastName", required = false) String lastName,
			@RequestParam(value = "times", required = false) Integer times) {
		String greeting = "";
		if(firstName == null && lastName == null && times == null) {
			return "Hello Human";
		}
		else if(firstName == null && times == null) {
			return "Hello Human";
		}
		else if(firstName == null && lastName == null) {
			return "Hello Human";
		}
		else if(lastName == null && times == null) {
			return "Hello " + firstName;
		}
		else if (firstName == null) {
			return "Hello Human";
		}
		else if (times == null) {
			return "Hello " + firstName + " " + lastName;
		}
		else if (firstName != null && lastName != null && times != null) {
			return "Hello Human";
		}
		else {
			for (int i = 0; i < times; i++) {
				greeting += "Hello " + firstName + " ";
			}
			return greeting;
		}
	}
}
