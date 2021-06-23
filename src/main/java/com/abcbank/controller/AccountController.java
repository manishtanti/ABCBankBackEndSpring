package com.abcbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.abcbank.service.AccountService;

@RestController
@CrossOrigin
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="/getAccounts/{customerId}",method=RequestMethod.GET)
	public Object getAccounts(@PathVariable Long customerId) {
		return accountService.getAccounts(customerId);	
		}

}
