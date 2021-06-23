package com.abcbank.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.abcbank.service.StatementService;

@RestController
@CrossOrigin
public class StatementController {
	@Autowired
	private StatementService statementService;
	
	@RequestMapping(value="/getStatements/{accountNumber}",method=RequestMethod.GET)
	public Object getStatementss(@PathVariable Long accountNumber) {
		return statementService.getStatements(accountNumber);	
		}
}
