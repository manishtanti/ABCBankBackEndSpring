package com.abcbank.service;

import com.abcbank.model.Query;

public interface QueryService {

	public Object saveQueryRequest(Query query);

	public Object getQueries(Long accountNumber);

	public Object getAllQueries();

	public Object getQueryById(Long id);

}
