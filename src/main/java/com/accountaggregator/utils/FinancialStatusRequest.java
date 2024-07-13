package com.accountaggregator.utils;

public class FinancialStatusRequest {

	private String customerId;
	private String consentId;
	private String sessionId;
	private String consentHandleId;

	// Constructors, getters, and setters

	public FinancialStatusRequest() {
	}

	public FinancialStatusRequest(String customerId, String consentId, String sessionId, String consentHandleId) {
		this.customerId = customerId;
		this.consentId = consentId;
		this.sessionId = sessionId;
		this.consentHandleId = consentHandleId;
	}

	// Getters and setters

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getConsentId() {
		return consentId;
	}

	public void setConsentId(String consentId) {
		this.consentId = consentId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getConsentHandleId() {
		return consentHandleId;
	}

	public void setConsentHandleId(String consentHandleId) {
		this.consentHandleId = consentHandleId;
	}

	@Override
	public String toString() {
		return "FinancialStatusRequest [customerId=" + customerId + ", consentId=" + consentId + ", sessionId="
				+ sessionId + ", consentHandleId=" + consentHandleId + "]";
	}

}
