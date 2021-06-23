package com.abcbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abcbank.model.ChequeRequest;
import com.abcbank.service.ChequeRequestService;

@RestController
@CrossOrigin
public class ChequeRequestController {
	
	@Autowired
	private ChequeRequestService chequeRequestService;
	
	@RequestMapping(value="/saveChequeRequest",method=RequestMethod.POST)
	public Object saveStudent(@RequestBody ChequeRequest chequeRequest) {
		return (chequeRequestService.saveChequeRequest(chequeRequest));
	}
	
	@RequestMapping(value="/getChequeRequests/{accountNumber}" , method=RequestMethod.GET)
	public Object getChequeRequests(@PathVariable Long accountNumber){
		return chequeRequestService.getChequeRequests(accountNumber);
	}
	
	@RequestMapping(value="/getAllChequeRequests" , method=RequestMethod.GET)
	public Object getAllChequeRequests(){
		return chequeRequestService.getAllChequeRequests();
	}
	
	@RequestMapping(value = "getChequeById/{id}",method = RequestMethod.GET)
	public Object getChequeById(@PathVariable long id) {
		return chequeRequestService.getChequeById(id);
	}
	
	
}
