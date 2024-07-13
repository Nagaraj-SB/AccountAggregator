package com.accountaggregator.utils;

public class ConsentRequest {

	private String mobileNumber;
	private String consentArtifactName;
	private String consentDescription;
	private String callbackUrl;

	// Constructors, getters, and setters

	public ConsentRequest() {
	}

	public ConsentRequest(String mobileNumber, String consentArtifactName, String consentDescription,
			String callbackUrl) {
		this.mobileNumber = mobileNumber;
		this.consentArtifactName = consentArtifactName;
		this.consentDescription = consentDescription;
		this.callbackUrl = callbackUrl;
	}

	// Getters and setters

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getConsentArtifactName() {
		return consentArtifactName;
	}

	public void setConsentArtifactName(String consentArtifactName) {
		this.consentArtifactName = consentArtifactName;
	}

	public String getConsentDescription() {
		return consentDescription;
	}

	public void setConsentDescription(String consentDescription) {
		this.consentDescription = consentDescription;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	@Override
	public String toString() {
		return "ConsentRequest [mobileNumber=" + mobileNumber + ", consentArtifactName=" + consentArtifactName
				+ ", consentDescription=" + consentDescription + ", callbackUrl=" + callbackUrl + "]";
	}

}
