package com.abcbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.abcbank.model.Statement;

@Repository
public interface StatementRepo extends JpaRepository<Statement, Long> {
	@Query("select s from Statement s where s.account.accountNumber=:accountNumber order by s.transactionDate desc")
	List<Statement> getStatements(@Param("accountNumber") Long accountNumber);
	
	
	@Query("select avg(s.closingBalance) from Statement s where s.account.accountNumber=:accountNumber")
	Double getAverageBalance(Long accountNumber);

}
