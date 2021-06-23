package com.abcbank.service;

import com.abcbank.model.LostCardReport;

public interface LostCardReportService {

	public Object saveLostCardRequest(LostCardReport lostCardReport);

	public Object getLostCardReports(Long accountNumber);

	public Object getAllLostCardReports();

	public Object getLostCardById(Long id);

}
