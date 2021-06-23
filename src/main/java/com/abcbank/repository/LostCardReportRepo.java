package com.abcbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abcbank.model.LostCardReport;

@Repository
public interface LostCardReportRepo extends JpaRepository<LostCardReport,Long>{
	@Query("select l from LostCardReport l where l.account.accountNumber=:accountNumber")
	List<LostCardReport> getLostCardReports(@Param("accountNumber") Long accountNumber);
	
	@Query("select l from LostCardReport l order by l.requestDate desc")
	List<LostCardReport> getAllLostCardReports();
}
