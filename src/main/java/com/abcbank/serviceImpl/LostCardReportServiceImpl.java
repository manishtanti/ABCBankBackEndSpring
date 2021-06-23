package com.abcbank.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcbank.model.LostCardReport;
import com.abcbank.repository.LostCardReportRepo;
import com.abcbank.service.LostCardReportService;

@Service
public class LostCardReportServiceImpl implements LostCardReportService{
	@Autowired
	private LostCardReportRepo lostCardReportRepo;

	@Override
	public Object saveLostCardRequest(LostCardReport lostCardReport) {
		HashMap<String, String> map = new HashMap<>();
		if(lostCardReport==null) {
			map.put("status", "404");
            map.put("message", "Invalid request");
            return map;
		}
		else if(lostCardReport.getRequestDate()==null) {
    		map.put("status", "404");
            map.put("message", "Request date cant be  null");
            return map;
    	} else if(lostCardReport.getStatus().trim().isEmpty()) {
    		map.put("status", "404");
            map.put("message", "status cant be  null");
            return map;
    	} else if(lostCardReport.getCardNumber()==null){
    		map.put("status", "404");
            map.put("message", "Invalid card number");
            return map;
    	} else if(lostCardReport.getLostOn()==null) {
    		map.put("status", "404");
            map.put("message", "Invalid lost on date");
            return map;
    	}
		LostCardReport obj = lostCardReportRepo.save(lostCardReport);
		
		if(obj == null) {
			map.put("status", "404");
			map.put("message","Some error occured");
		} else {
			map.put("status", "200");
			map.put("message","Your request placed successfully");
		}
		return map;
	}
	
	@Transactional
	@Override
	public Object getLostCardReports(Long accountNumber) {
		List<LostCardReport> lcrList=lostCardReportRepo.getLostCardReports(accountNumber);
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		for(LostCardReport l : lcrList) 
		{
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("requestDate", l.getRequestDate());
			map.put("requestType","Card stolen");
			map.put("requestDetails","Your card:"+l.getCardNumber() +" was stolen on "+l.getLostOn());
			map.put("response", l.getDescription());
			map.put("status", l.getStatus());
			list.add(map);
		}
		return list;
		
	}

	@Override
	@Transactional
	public Object getAllLostCardReports() {
		List<LostCardReport> lcrList=lostCardReportRepo.getAllLostCardReports();
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		for(LostCardReport l : lcrList) 
		{
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("cardNumber", l.getCardNumber());
			map.put("requestDate", l.getRequestDate());
			map.put("requestType","Card stolen");
			map.put("requestDetails","Your card:"+l.getCardNumber() +" was stolen on "+l.getLostOn());
			map.put("response", l.getDescription());
			map.put("status", l.getStatus());
			list.add(map);
		}
		return list;
	}

	@Override
	public Object getLostCardById(Long id) {
		Map<String, Object> map=new HashMap<String, Object>();
		LostCardReport l = lostCardReportRepo.findById(id).orElse(null);
		if(l==null) {
			map.put("status", "404");
		} else {
			map.put("cardNumber", l.getCardNumber());
			map.put("requestDate", l.getRequestDate());
			map.put("requestType","Card stolen");
			map.put("requestDetails","Your card:"+l.getCardNumber() +" was stolen on "+l.getLostOn());
			map.put("description", l.getDescription());
			map.put("lostOn",l.getLostOn());
			map.put("account", l.getAccount().getAccountNumber());
			map.put("status", l.getStatus());
		}
		return map;
	}

}
