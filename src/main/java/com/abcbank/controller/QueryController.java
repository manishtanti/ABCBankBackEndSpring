package com.abcbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abcbank.model.Query;
import com.abcbank.service.QueryService;

@RestController
@CrossOrigin
public class QueryController {
	
	@Autowired
	private QueryService queryService;
	
	
	@RequestMapping(value="/saveQueryRequest",method=RequestMethod.POST)
	public Object saveStudent(@RequestBody Query query) {
		return (queryService.saveQueryRequest(query));
	}
	
	@RequestMapping(value="/getQueries/{accountNumber}" , method=RequestMethod.GET)
	public Object getQueries(@PathVariable Long accountNumber){
		return queryService.getQueries(accountNumber);
	}
	
	@RequestMapping(value="/getAllQueries" , method=RequestMethod.GET)
	public Object getAllQueries(){
		return queryService.getAllQueries();
	}
	
	@RequestMapping(value = "/getQueryById/{id}",method = RequestMethod.GET)
	public Object getQueryById(@PathVariable Long id) {
		return queryService.getQueryById(id);
	}

}
