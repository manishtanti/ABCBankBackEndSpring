package com.abcbank.service;

import com.abcbank.model.Employee;
import com.abcbank.model.Password;

public interface EmployeeService {

	public Object getEmployeeWithUsername(Employee employee);

	public Object getEmployeeById(Long id);

	public Object updateEmployee(Employee employee);

	public Object changePassword(Password password);

}
