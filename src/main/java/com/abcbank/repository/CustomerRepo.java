	package com.abcbank.repository;
	
	import java.util.List;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;
	import org.springframework.data.repository.query.Param;
	import org.springframework.stereotype.Repository;


	import com.abcbank.model.Customer;
	
	
	
	@Repository
	public interface CustomerRepo extends JpaRepository<Customer,Long> {
		
		@Query("select c from Customer c where c.username=:username and c.password=:password")
		Customer getCustomerDetails(@Param("username") String username,@Param("password") String password);

		@Query("select c from Customer c where c.customerId=:customerId")
		List<Customer> getAllCustomerById(@Param("customerId") int customerId);

		
	}
