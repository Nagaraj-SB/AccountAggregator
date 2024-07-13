package com.accountaggregator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accountaggregator.service.ConsentRequestService;
import com.accountaggregator.service.ConsentStatusService;
import com.accountaggregator.service.FinancialInformationService;
import com.accountaggregator.service.FinancialRequestService;
import com.accountaggregator.service.FinancialStatusService;
import com.accountaggregator.utils.ConsentRequest;
import com.accountaggregator.utils.ConsentStatusRequest;
import com.accountaggregator.utils.FinancialInformationRequest;
import com.accountaggregator.utils.FinancialRequest;
import com.accountaggregator.utils.FinancialStatusRequest;

@RestController
@RequestMapping("/saswat")
public class AccountAggregatorController {

	@Autowired
	ConsentRequestService consentRequestService;
	@Autowired
	ConsentStatusService consentStatusService;
	@Autowired
	FinancialRequestService financialRequestService;
	@Autowired
	FinancialStatusService financialStatusService;
	@Autowired
	FinancialInformationService financialInformationService;

	@PostMapping(value = "/consent_request", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getConsentRequest(@RequestBody ConsentRequest consentRequest) {
		return consentRequestService.fetchConsentRequest(consentRequest);

	}

	@PostMapping(value = "/consent_status", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getConsentStatus(@RequestBody ConsentStatusRequest consentStatusRequest) {
		return consentStatusService.fetchConsentStatus(consentStatusRequest);

	}

	@PostMapping(value = "/financial_request", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getFinancialRequest(@RequestBody FinancialRequest financialRequest) {
		return financialRequestService.fetchFinancialRequest(financialRequest);

	}

	@PostMapping(value = "/financial_status", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getFinancialStatus(@RequestBody FinancialStatusRequest financialStatusRequest) {
		return financialStatusService.fetchFinancialStatus(financialStatusRequest);

	}

	@PostMapping(value = "/getting_financial_information", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getFinancialInformation(@RequestBody FinancialInformationRequest financialInformationRequest) {
		return financialInformationService.fetchFinancialInformation(financialInformationRequest);

	}

}
