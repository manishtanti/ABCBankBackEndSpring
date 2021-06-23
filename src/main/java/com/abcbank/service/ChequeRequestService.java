package com.abcbank.service;


import com.abcbank.model.ChequeRequest;

public interface ChequeRequestService {

	public Object saveChequeRequest(ChequeRequest chequeRequest);

	public Object getChequeRequests(Long accountNumber);

	public Object getAllChequeRequests();

	public Object getChequeById(long id);



}
