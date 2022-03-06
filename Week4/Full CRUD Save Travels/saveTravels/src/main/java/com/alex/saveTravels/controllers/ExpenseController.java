package com.alex.saveTravels.controllers;

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

import com.alex.saveTravels.models.Expense;
import com.alex.saveTravels.services.ExpenseService;

@Controller
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;
	
	@GetMapping("/")
		public String index() {
		
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses")
		public String allExpenses(Expense expense, Model viewModel) {
		
			viewModel.addAttribute("expenses", expenseService.allExpenses());
			return "index.jsp";
		}
	
	@PostMapping("/expenses/create")
		public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		
			if(result.hasErrors()) {
				return "index.jsp";
			} else {
				expenseService.createExpense(expense);
				return "redirect:/";
			}
		}
	
	@GetMapping("/expenses/{id}")
		public String getExpense(@PathVariable("id") Long id, Model viewModel) {
		
			viewModel.addAttribute("expense", expenseService.findExpense(id));
			return "show.jsp";
		}
	
	@GetMapping("/expenses/{id}/edit")
		public String editExpense(@PathVariable("id") Long id, Model viewModel) {
		
			Expense expense = expenseService.findExpense(id);
			
			viewModel.addAttribute("expense", expense);
			return "edit.jsp";
		
	}
	
	@PutMapping("/expenses/{id}/update")
		public String updateExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			expenseService.updateExpense(expense);
			return "redirect:/";
		}
	}
	
	@DeleteMapping("/expenses/{id}/delete")
		public String destroy(@PathVariable("id") Long id) {
			
			expenseService.deleteExpense(id);
			return "redirect:/";
		}
	
	
}
