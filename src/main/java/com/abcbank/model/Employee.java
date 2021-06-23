package com.abcbank.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="employee_tbl")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="employee_id")
	private Long employeeId;
	
	@Column(name="employee_name",length=30,nullable = false)
	private String employeeName;
	
	@Column(name="mobile_number",length=10,nullable = false)
	private String mobileNumber;
	
	@Column(name="email",length=30)
	private String email;
	
	@Column(name="pan_number",length=15)
	private String panNumber;
	
	@Column(name="address",length=100,nullable = false)
	private String address;
	
	@Column(name="username",length=30,nullable = false)
	private String username;
	
	@Column(name="password",length=30,nullable = false)
	private String password;
	
	@Column(name="dob",nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@Column(name="city",length=30,nullable = false)
	private String city;
	
	@Column(name="pincode",nullable = false)
	private Integer pinCode;
	
	@Column(name="country",length=30,nullable = false)
	private String country;
	
	@Column(name="gender",length=10,nullable = false)
	private String gender;
	
	@Column(name="adhar",length=20,nullable = false)
	private String adhar;

	

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAdhar() {
		return adhar;
	}

	public void setAdhar(String adhar) {
		this.adhar = adhar;
	}	
}
