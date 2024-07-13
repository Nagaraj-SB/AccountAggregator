package com.accountaggregator.service;

import com.accountaggregator.utils.ConsentStatusRequest;

public interface ConsentStatusService {

	public String fetchConsentStatus(ConsentStatusRequest consentStatusRequest);

}
