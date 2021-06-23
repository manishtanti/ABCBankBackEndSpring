package com.abcbank.serviceImpl;

import java.util.HashMap;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.abcbank.model.Customer;
import com.abcbank.model.Password;
import com.abcbank.repository.CustomerRepo;
import com.abcbank.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerRepo customerRepo;
	
	

	@Override
	@Transactional
	public Object getCustomerWithUsername(Customer customer) {
		Customer validCustomer = customerRepo.getCustomerDetails(customer.getUsername() ,customer.getPassword());
		HashMap<String,Object> map = new HashMap<>();
		if(validCustomer == null) {
			map.put("status", "404");
		}else {
			map.put("status", "200");
			map.put("customerId", validCustomer.getCustomerId());
			map.put("customerName", validCustomer.getCustomerName());
		}
		return map;
	}

	@Override
	@Transactional
	public Object getCustomerById(Long id) {
		Customer customer = customerRepo.findById(id).orElse(null);
		HashMap<String,Object> map = new HashMap<>();
		if(customer == null) {
			map.put("status", "404");
		}else {
			map.put("status", "200");
			map.put("customerId", customer.getCustomerId());
			map.put("customerName", customer.getCustomerName());
			map.put("mobileNumber", customer.getMobileNumber());
			map.put("email", customer.getEmail());
			map.put("panNumber", customer.getPanNumber());
			map.put("address", customer.getAddress());
			map.put("city", customer.getCity());
			map.put("pinCode", customer.getPinCode());
			map.put("country", customer.getCountry());
			map.put("dob", customer.getDob());
			map.put("gender", customer.getGender());	
		}
		return map;
	}

	@Override
	@Transactional
	public Object updateCustomer(Customer customer) {
		HashMap<String,Object> map = new HashMap<>();
		Customer c = customerRepo.getById(customer.getCustomerId());
		customer.setUsername(c.getUsername());
		customer.setPassword(c.getPassword());
		customer.setAdhar(c.getAdhar());
		Customer res = customerRepo.saveAndFlush(customer);
		
		if(res==null) {
			map.put("status", "405");
		}else {
			map.put("status", "200");
			map.put("message", "Your profile updated successfully");
		}
		
		return map;
	}

	

	@Override
	@Transactional
	public Object changePassword(Password password) {
		HashMap<String,String> map = new HashMap<>();
		Customer customer = customerRepo.findById(password.getId()).orElse(null);
		if(customer==null) {
			map.put("status", "404");
			map.put("message", "Customer Not Found");
		}else if(!customer.getPassword().equals(password.getOldPassword())) {
			map.put("status", "320");
			map.put("message", "You entered wrong current password");
		}else if(customer.getPassword().equals(password.getNewPassword())) {
			map.put("status", "321");
			map.put("message", "Password same as old");
		}else {
			customer.setPassword(password.getNewPassword());
			Customer res = customerRepo.saveAndFlush(customer);
			if(res!=null) {
				map.put("status", "200");
				map.put("message", "password changed successfully");
			}else {
				map.put("status", "322");
				map.put("message", "Some error occured");
			}
		}
		return map;
	}

}
