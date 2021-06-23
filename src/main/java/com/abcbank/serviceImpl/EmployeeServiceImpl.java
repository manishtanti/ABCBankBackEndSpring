package com.abcbank.serviceImpl;

import java.util.HashMap;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcbank.model.Employee;
import com.abcbank.model.Password;
import com.abcbank.repository.EmployeeRepo;
import com.abcbank.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	@Transactional
	public Object getEmployeeWithUsername(Employee employee) {
		Employee validEmployee = employeeRepo.getEmployeeDetails(employee.getUsername() ,employee.getPassword());
		HashMap<String,Object> map = new HashMap<>();
		if(validEmployee == null) {
			map.put("status", "404");
			map.put("message", "Invalid Username or Password");
		}else {
			map.put("status", "200");
			map.put("message", "Login Successfull");
			map.put("employeeId", validEmployee.getEmployeeId());
			map.put("employeeName", validEmployee.getEmployeeName());
		}
		return map;
	}
	
	@Override
	@Transactional
	public Object getEmployeeById(Long id) {
		Employee employee = employeeRepo.findById(id).orElse(null);
		HashMap<String,Object> map = new HashMap<>();
		if(employee == null) {
			map.put("status", "404");
		}else {
			map.put("status", "200");
			map.put("employeeId", employee.getEmployeeId());
			map.put("employeeName", employee.getEmployeeName());
			map.put("mobileNumber", employee.getMobileNumber());
			map.put("email", employee.getEmail());
			map.put("panNumber", employee.getPanNumber());
			map.put("address", employee.getAddress());
			map.put("city", employee.getCity());
			map.put("pinCode", employee.getPinCode());
			map.put("country", employee.getCountry());
			map.put("dob", employee.getDob());
			map.put("gender", employee.getGender());	
		}
		return map;
	}

	@Override
	@Transactional
	public Object updateEmployee(Employee employee) {
		HashMap<String,Object> map = new HashMap<>();
		Employee e = employeeRepo.getById(employee.getEmployeeId());
		employee.setUsername(e.getUsername());
		employee.setPassword(e.getPassword());
		employee.setAdhar(e.getAdhar());
		Employee res = employeeRepo.saveAndFlush(employee);
		
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
		Employee employee = employeeRepo.findById(password.getId()).orElse(null);
		if(employee==null) {
			map.put("status", "404");
			map.put("message", "Customer Not Found");
		}else if(!employee.getPassword().equals(password.getOldPassword())) {
			map.put("status", "320");
			map.put("message", "You entered wrong current password");
		}else if(employee.getPassword().equals(password.getNewPassword())) {
			map.put("status", "321");
			map.put("message", "Password same as old");
		}else {
			employee.setPassword(password.getNewPassword());
			Employee res = employeeRepo.saveAndFlush(employee);
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
