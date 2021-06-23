package com.abcbank.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.abcbank.model.Customer;
import com.abcbank.model.Password;
import com.abcbank.service.CustomerService;

@RestController
@CrossOrigin
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/customerValidation",method=RequestMethod.POST)
	public Object getCustomer(@RequestBody Customer customer) {
		return customerService.getCustomerWithUsername(customer);
	}
	
	@RequestMapping(value="/getCustomerById/{id}",method=RequestMethod.GET)
	public Object getCustomerById(@PathVariable Long id) {
		return customerService.getCustomerById(id);
	}
	
	@RequestMapping(value="/updateCustomer",method=RequestMethod.PUT)
	public Object updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}
	
	
	@RequestMapping(value="/changePassword",method=RequestMethod.PUT)
	public Object changePassword(@RequestBody Password password) {
		return customerService.changePassword(password);
	}
	
	
}
