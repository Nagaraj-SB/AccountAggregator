package com.accountaggregator.service;

import com.accountaggregator.utils.FinancialInformationRequest;

public interface FinancialInformationService {

	public String fetchFinancialInformation(FinancialInformationRequest financialInformationRequest);

}
