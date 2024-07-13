package com.accountaggregator.utils;

public class FinancialInformationRequest {

	private String outputFormat;
	private String consentHandleId;
	private String sessionId;

	// Constructors, getters, and setters

	public FinancialInformationRequest() {
	}

	public FinancialInformationRequest(String outputFormat, String consentHandleId, String sessionId) {
		this.outputFormat = outputFormat;
		this.consentHandleId = consentHandleId;
		this.sessionId = sessionId;
	}

	// Getters and setters

	public String getOutputFormat() {
		return outputFormat;
	}

	public void setOutputFormat(String outputFormat) {
		this.outputFormat = outputFormat;
	}

	public String getConsentHandleId() {
		return consentHandleId;
	}

	public void setConsentHandleId(String consentHandleId) {
		this.consentHandleId = consentHandleId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Override
	public String toString() {
		return "FinancialInformationRequest [outputFormat=" + outputFormat + ", consentHandleId=" + consentHandleId
				+ ", sessionId=" + sessionId + "]";
	}

}
