package com.abcbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abcbank.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	@Query("select e from Employee e where e.username=:username and e.password=:password")
	Employee getEmployeeDetails(@Param("username") String username,@Param("password") String password);

}
