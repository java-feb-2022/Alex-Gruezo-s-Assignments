package com.alex.dojosAndNinjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.alex.dojosAndNinjas.models.Dojo;
import com.alex.dojosAndNinjas.models.Ninja;
import com.alex.dojosAndNinjas.services.DojoService;
import com.alex.dojosAndNinjas.services.NinjaService;

@Controller
public class MainController {
	
	@Autowired
	private DojoService dojoService;
	
	@Autowired
	private NinjaService ninjaService;
	
	@GetMapping("/")
	public String index(Model viewModel) {
		
		viewModel.addAttribute("dojos", dojoService.getAllDojos());
		return "index.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String dojo(@ModelAttribute("dojo") Dojo dojo) {
		
		return "dojo.jsp";
	}
	
	@GetMapping("/ninjas/new")
	public String ninja(@ModelAttribute("ninja") Ninja ninja, Model viewModel) {
		
		viewModel.addAttribute("dojos", dojoService.getAllDojos());
		return "ninja.jsp";
	}
	
	@PostMapping("dojos/create")
	public String createDojo(@ModelAttribute("dojo") Dojo dojo) {
		
		dojoService.createDojo(dojo);
		return "redirect:/";
	}
	
	@PostMapping("/ninjas/create")
	public String createNinja(@ModelAttribute("ninja") Ninja ninja, Model viewModel) {
				
		ninjaService.createNinja(ninja);
		return "redirect:/";
	}
	
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable Long id, Model viewModel) {
		
		
		viewModel.addAttribute("dojo", dojoService.getDojo(id));
		return "show.jsp";
	}
	
}
