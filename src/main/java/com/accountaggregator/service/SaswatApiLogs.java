package com.accountaggregator.service;

public interface SaswatApiLogs {

	public void saveConsentRequestApiLogs(String consentRequest, String consentHandleId, String ResponseStatus,
			String apiName, long timeStamp);

	public void saveConsentStatusApiLogs(String consentStatusRequest, String response, String apiName, String consentId,
			long timeStamp);

	public void saveFinancialInformationApiLogs(String financialInformationRequest, String response, String AAResponse,
			String apiName, long timeStamp);

	public void saveFinancialRequestApiLogs(String financialRequest, String response, String sessionId, String apiName,
			long timeStamp);

	public void saveFinancialStatusEnityApiLogs(String financialStatusRequest, String response, String fiRequestStatus,
			String apiName, long timeStamp);

}
