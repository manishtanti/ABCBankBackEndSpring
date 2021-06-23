package com.abcbank.service;


import com.abcbank.model.Customer;
import com.abcbank.model.Password;

public interface CustomerService {
	public Object getCustomerWithUsername(Customer customer);
	public Object getCustomerById(Long id);
	public Object updateCustomer(Customer customer);
	public Object changePassword(Password password);
}
