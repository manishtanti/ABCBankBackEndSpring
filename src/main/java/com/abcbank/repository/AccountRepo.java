package com.abcbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abcbank.model.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
	@Query("select a from Account a where a.customer.customerId=:customerId")
	List<Account> getAccounts(@Param("customerId") Long customerId);
	
}
