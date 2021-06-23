package com.abcbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abcbank.model.ChequeRequest;

@Repository
public interface ChequeRequestRepo extends JpaRepository<ChequeRequest, Long> {
	@Query("select c from ChequeRequest c where c.account.accountNumber=:accountNumber")
	List<ChequeRequest> getChequeRequests(@Param("accountNumber") Long accountNumber);
	
	@Query("select c from ChequeRequest c order by c.requestDate desc")
	List<ChequeRequest> getAllChequeRequests();
}
