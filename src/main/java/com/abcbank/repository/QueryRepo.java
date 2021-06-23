package com.abcbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abcbank.model.Query;

@Repository
public interface QueryRepo extends JpaRepository<Query, Long>{
	@org.springframework.data.jpa.repository.Query("select q from Query q where q.account.accountNumber=:accountNumber")
	List<Query> getQueries(@Param("accountNumber") Long accountNumber);
	
	@org.springframework.data.jpa.repository.Query("select q from Query q order by q.requestDate desc")
	List<Query> getAllQueries();
}
