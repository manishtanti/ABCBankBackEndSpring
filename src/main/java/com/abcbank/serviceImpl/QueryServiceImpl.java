package com.abcbank.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.abcbank.model.Query;
import com.abcbank.repository.QueryRepo;
import com.abcbank.service.QueryService;

@Service
public class QueryServiceImpl implements QueryService {
	
	@Autowired
	private QueryRepo queryRepo;

	@Override
	@Transactional
	public Object saveQueryRequest(Query query) {
		HashMap<String, String> map = new HashMap<>();
		if(query.getQuery().trim().length()<10) {
			map.put("status", "404");
            map.put("message", "At least 10 character required");
            return map;
		}
		Query obj = queryRepo.save(query);
		
		if(obj == null) {
			map.put("status", "404");
			map.put("message","Some error occured");
		} else {
			map.put("status", "200");
			map.put("message","Your request placed successfully");
		}
		return map;
	}

	@Override
	@Transactional
	public Object getQueries(Long accountNumber) {
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		if(accountNumber==null) {
			return list;
		}
		List<Query> qList=queryRepo.getQueries(accountNumber);
		for(Query q : qList) 
		{
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("requestDate", q.getRequestDate());
			map.put("requestType","Query");
			map.put("requestDetails","A/c No. "+q.getAccount().getAccountNumber()+" : "+q.getQuery());
			map.put("response", q.getDescription());
			map.put("status", q.getStatus());
			list.add(map);
		}
		return list;
	}

	@Override
	@Transactional
	public Object getAllQueries() {
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		List<Query> qList=queryRepo.getAllQueries();
		for(Query q : qList) 
		{
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("queryId", q.getQueryId());
			map.put("requestDate", q.getRequestDate());
			map.put("requestType","Query");
			map.put("requestDetails","A/c No. "+q.getAccount().getAccountNumber()+" : "+q.getQuery());
			map.put("response", q.getDescription());
			map.put("status", q.getStatus());
			list.add(map);
		}
		return list;
	}

	@Override
	public Object getQueryById(Long id) {
		Map<String, Object> map=new HashMap<String, Object>();
		Query q = queryRepo.findById(id).orElse(null);
		if(q==null) {
			map.put("status", "404");
		} else {
			map.put("queryId", q.getQueryId());
			map.put("requestDate", q.getRequestDate());
			map.put("requestType","Query");
			map.put("query", q.getQuery());
			map.put("requestDetails","A/c No. "+q.getAccount().getAccountNumber()+" : "+q.getQuery());
			map.put("description", q.getDescription());
			map.put("account", q.getAccount().getAccountNumber());
			map.put("status", q.getStatus());
		}
		return map;
	}

}
