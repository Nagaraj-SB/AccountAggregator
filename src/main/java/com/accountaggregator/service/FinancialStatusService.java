package com.accountaggregator.service;

import com.accountaggregator.utils.FinancialStatusRequest;

public interface FinancialStatusService {

	public String fetchFinancialStatus(FinancialStatusRequest financialStatusRequest);

}
