package com.accountaggregator.utils;

public class ConsentStatusRequest {

	private String mobileNumber;
	private String consentHandleId;

	// Constructors, getters, and setters

	public ConsentStatusRequest() {
	}

	public ConsentStatusRequest(String mobileNumber, String consentHandleId) {
		this.mobileNumber = mobileNumber;
		this.consentHandleId = consentHandleId;
	}

	// Getters and setters

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getConsentHandleId() {
		return consentHandleId;
	}

	public void setConsentHandleId(String consentHandleId) {
		this.consentHandleId = consentHandleId;
	}

	@Override
	public String toString() {
		return "ConsentStatusRequest [mobileNumber=" + mobileNumber + ", consentHandleId=" + consentHandleId + "]";
	}

}
