package com.abcbank.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcbank.model.ChequeRequest;
import com.abcbank.repository.ChequeRequestRepo;
import com.abcbank.service.ChequeRequestService;

@Service
public class ChequeRequestServiceImpl implements ChequeRequestService {
    @Autowired
    private ChequeRequestRepo chequeRequestRepo;


    @Transactional
    @Override
    public Object saveChequeRequest(ChequeRequest chequeRequest) {
    	HashMap<String, String> map = new HashMap<>();
    	
    	if(chequeRequest.getRequestDate()==null) {
    		map.put("status", "404");
            map.put("message", "Request date cant be  null");
            return map;
    	} else if(chequeRequest.getStatus().trim().isEmpty()) {
    		map.put("status", "404");
            map.put("message", "status cant be  null");
            return map;
    	} else if(!(chequeRequest.getChequeLeaves()==20 ||chequeRequest.getChequeLeaves()==50 || chequeRequest.getChequeLeaves()==100)){
    		map.put("status", "404");
            map.put("message", "Invalid cheque leaves count");
            return map;
    	}
        ChequeRequest obj = chequeRequestRepo.save(chequeRequest);

        if (obj == null) {
            map.put("status", "404");
            map.put("message", "Some error occured");
        } else {
            map.put("status", "200");
            map.put("message", "Your request placed successfully");
        }
        return map;
    }

    @Transactional
    @Override
    public Object getChequeRequests(Long accountNumber) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        if (accountNumber == null) {
            return list;
        }
        List<ChequeRequest> crList = chequeRequestRepo.getChequeRequests(accountNumber);
        for (ChequeRequest c : crList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("requestDate", c.getRequestDate());
            map.put("requestType", "Cheque");
            map.put("requestDetails",
                    "A/c No: " + c.getAccount().getAccountNumber() + "  || Cheques leaves: " + c.getChequeLeaves());
            map.put("response", c.getDescription());
            map.put("status", c.getStatus());
            list.add(map);
        }
        return list;
    }

	@Override
	@Transactional
	public Object getAllChequeRequests() {
		 List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	        List<ChequeRequest> crList = chequeRequestRepo.getAllChequeRequests();
	        for (ChequeRequest c : crList) {
	            Map<String, Object> map = new HashMap<String, Object>();
	            map.put("chequeNumber", c.getChequeNumber());
	            map.put("requestDate", c.getRequestDate());
	            map.put("requestType", "Cheque");
	            map.put("requestDetails",
	                    "A/c No: " + c.getAccount().getAccountNumber() + "  || Cheques leaves: " + c.getChequeLeaves());
	            map.put("response", c.getDescription());
	            map.put("status", c.getStatus());
	            list.add(map);
	        }
	        return list;
	}

	@Override
	@Transactional
	public Object getChequeById(long id) {
		ChequeRequest c = chequeRequestRepo.findById(id).orElse(null);
		HashMap<String,Object> map = new HashMap<>();
		if(c == null) {
			map.put("status", "404");
		}else {
			map.put("chequeNumber", c.getChequeNumber());
            map.put("requestDate", c.getRequestDate());
            map.put("requestType", "Cheque");
            map.put("chequeLeaves", c.getChequeLeaves());
            map.put("requestDetails",
                    "A/c No: " + c.getAccount().getAccountNumber() + "  || Cheques leaves: " + c.getChequeLeaves());
            map.put("description", c.getDescription());
            map.put("status", c.getStatus());
			map.put("account", c.getAccount().getAccountNumber());
		}
		return map;
	}
    

}
