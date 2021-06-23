package com.abcbank.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.abcbank.model.Statement;
import com.abcbank.repository.StatementRepo;
import com.abcbank.service.StatementService;

@Service
public class StatementServiceImpl implements StatementService{
	
	@Autowired
	private StatementRepo statementRepo;

	@Override
	@Transactional
	public Object getStatements(Long accountNumber) {
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		if(accountNumber==null) {
			return list;
		}
		
		List<Statement> stmtList=statementRepo.getStatements(accountNumber);
		for(Statement s : stmtList) 
		{
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("transactionDate", s.getTransactionDate());
			map.put("description",s.getDescription());
			map.put("type",s.getType());
			map.put("amount", s.getCreditOrDebitAmount());
			map.put("closingBalance", s.getClosingBalance());
			list.add(map);
		}
		return list;
	}

}
