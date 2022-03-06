package com.alex.languages.controllers;

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

import com.alex.languages.models.Language;
import com.alex.languages.services.LanguageService;

@Controller
public class LanguageController {

	@Autowired
	private LanguageService languageService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/languages";
	}
	
	@GetMapping("/languages")
	public String allLanguages (Language language, Model viewModel) {
		
		viewModel.addAttribute("languages", languageService.allLanguages());
		return "index.jsp";
	}
	
	@PostMapping("/languages/create")
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			languageService.createLanguage(language);
			return "redirect:/";
		}
	}
	
	@GetMapping("/languages/{id}")
	public String getLanguage(@PathVariable("id") Long id, Model viewModel) {
		
		viewModel.addAttribute("language", languageService.findLanguage(id));
		return "show.jsp";
	}
	
	@GetMapping("/languages/edit/{id}")
	public String editLanguage(@PathVariable("id") Long id, Model viewModel) {
		
		Language language = languageService.findLanguage(id);
			
		viewModel.addAttribute("language", language);
		return "edit.jsp";
	}
	
	@PutMapping("/languages/udpate/{id}")
	public String updateLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			languageService.updateLanguage(language);
			return "redirect:/";
		}
	}
	
	@DeleteMapping("/languages/delete/{id}")
	public String destroy(@PathVariable("id") Long id) {
		
		languageService.deleteLanguage(id);
		return "redirect:/";
	}
}
