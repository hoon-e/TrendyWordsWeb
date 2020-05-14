package com.yujachan.TrendyWordsWeb.controller;

import java.util.ArrayList;
import java.util.List;

import com.yujachan.TrendyWordsWeb.domain.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yujachan.TrendyWordsWeb.service.ExpenseService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
<<<<<<< HEAD
@RequestMapping("/trendy")
=======
@RequestMapping("/expense")
>>>>>>> 3dfc10969c88fffda76b1e3f1b65634bc1809b02
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;
	
	
	@GetMapping
	public ResponseEntity<?> getAll() {
		List<Expense> result = expenseService.findAll();
		return new ResponseEntity(result, HttpStatus.OK);
	}
	
	@GetMapping("/{year}/{month}")
	public ResponseEntity<?> getByMonthYear(@PathVariable("year") int year, @PathVariable("month") String month) {
		List<Expense> result = new ArrayList<>();
		if("All".equals(month)) {
			result = expenseService.findByYear(year);
		} else {
			result = expenseService.findByMonthAndYear(month, year);			
		}
		return new ResponseEntity(result, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> addorUpdateExpense(@RequestBody Expense expense) {
		expenseService.saveOrUpdateExpense(expense);
		return new ResponseEntity("Expense added succcessfully", HttpStatus.OK);
	}
	
	@DeleteMapping
	public void deleteExpense(@RequestParam("id") String id) {
		expenseService.deleteExpense(id);
	}
	

}