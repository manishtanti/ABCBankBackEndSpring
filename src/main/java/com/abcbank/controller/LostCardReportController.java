package com.abcbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abcbank.model.LostCardReport;
import com.abcbank.service.LostCardReportService;

@RestController
@CrossOrigin
public class LostCardReportController {
	
	@Autowired
	private LostCardReportService lostCardReportService;
	
	
	@RequestMapping(value="/saveLostCardRequest",method=RequestMethod.POST)
	public Object saveLostCardRequest(@RequestBody LostCardReport lostCardReport) {
		return lostCardReportService.saveLostCardRequest(lostCardReport);
	}
	
	@RequestMapping(value="/getLostCardReports/{accountNumber}" , method=RequestMethod.GET)
	public Object getLostCardReports(@PathVariable Long accountNumber){
		return lostCardReportService.getLostCardReports(accountNumber);
	}
	
	@RequestMapping(value="/getAllLostCardReports" , method=RequestMethod.GET)
	public Object getAllLostCardReports(){
		return lostCardReportService.getAllLostCardReports();
	}
	
	
	@RequestMapping(value = "getLostCardById/{id}",method = RequestMethod.GET)
	public Object getLostCardById(@PathVariable Long id) {
		return lostCardReportService.getLostCardById(id);
	}
	
	

}
