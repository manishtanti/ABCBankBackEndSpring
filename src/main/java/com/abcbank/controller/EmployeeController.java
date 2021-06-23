package com.abcbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abcbank.model.Employee;
import com.abcbank.model.Password;
import com.abcbank.service.EmployeeService;

@RestController
@CrossOrigin
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/employeeValidation",method=RequestMethod.POST)
	public Object getEmployee(@RequestBody Employee employee) {
		return employeeService.getEmployeeWithUsername(employee);
	}
	
	@RequestMapping(value="/getEmployeeById/{id}",method=RequestMethod.GET)
	public Object getEmployeeById(@PathVariable Long id) {
		return employeeService.getEmployeeById(id);
	}
	
	@RequestMapping(value="/updateEmployee",method=RequestMethod.PUT)
	public Object updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}
	
	
	@RequestMapping(value="/changeEmployeePassword",method=RequestMethod.PUT)
	public Object changePassword(@RequestBody Password password) {
		return employeeService.changePassword(password);
	}
}
