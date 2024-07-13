package com.accountaggregator.utils;

public class FinancialRequest {

	private String customerId;
	private String consentId;
	private String consentHandleId;
	private String dateTimeRangeFrom;
	private String dateTimeRangeTo;

	// Constructors, getters, and setters

	public FinancialRequest() {
	}

	public FinancialRequest(String customerId, String consentId, String consentHandleId, String dateTimeRangeFrom,
			String dateTimeRangeTo) {
		this.customerId = customerId;
		this.consentId = consentId;
		this.consentHandleId = consentHandleId;
		this.dateTimeRangeFrom = dateTimeRangeFrom;
		this.dateTimeRangeTo = dateTimeRangeTo;
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

	public String getConsentHandleId() {
		return consentHandleId;
	}

	public void setConsentHandleId(String consentHandleId) {
		this.consentHandleId = consentHandleId;
	}

	public String getDateTimeRangeFrom() {
		return dateTimeRangeFrom;
	}

	public void setDateTimeRangeFrom(String dateTimeRangeFrom) {
		this.dateTimeRangeFrom = dateTimeRangeFrom;
	}

	public String getDateTimeRangeTo() {
		return dateTimeRangeTo;
	}

	public void setDateTimeRangeTo(String dateTimeRangeTo) {
		this.dateTimeRangeTo = dateTimeRangeTo;
	}

	@Override
	public String toString() {
		return "FinancialRequest [customerId=" + customerId + ", consentId=" + consentId + ", consentHandleId="
				+ consentHandleId + ", dateTimeRangeFrom=" + dateTimeRangeFrom + ", dateTimeRangeTo=" + dateTimeRangeTo
				+ "]";
	}

}
