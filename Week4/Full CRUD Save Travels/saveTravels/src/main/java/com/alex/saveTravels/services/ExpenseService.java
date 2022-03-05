package com.alex.saveTravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.saveTravels.models.Expense;
import com.alex.saveTravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	public List<Expense> allExpenses() {
		
		return expenseRepository.findAll();
		
	}
	
	public Expense createExpense(Expense expense) {
		
		return expenseRepository.save(expense);
		
	}
	
	public Expense findExpense(Long id) {
		
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
			if(optionalExpense.isPresent()) {
				return optionalExpense.get();
			} else {
				return null;
			}
			
	}
	
	public Expense updateExpense(Expense expense) {
		
		return expenseRepository.save(expense);
		
	}
	
	public void deleteExpense(Long id) {
		
		expenseRepository.deleteById(id);
		
	}

}
