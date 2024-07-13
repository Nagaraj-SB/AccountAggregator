package com.accountaggregator.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("file:src/main/resources/application.properties")
public class PropertiesConfig {

	@Value("${AccountAggregatorTocken}")
	private String accountAggregatorTocken;

	@Value("${ConsentUrl}")
	private String consentUrl;

	@Value("${ConsentStatusUrl}")
	private String consentStatusUrl;

	@Value("${FinancialUrl}")
	private String financialUrl;

	@Value("${FinancialStatusUrl}")
	private String financialStatusUrl;

	@Value("${FinancialInformationUrl}")
	private String financialInformationUrl;

	public String getAccountAggregatorTocken() {
		return accountAggregatorTocken;
	}

	public void setAccountAggregatorTocken(String accountAggregatorTocken) {
		this.accountAggregatorTocken = accountAggregatorTocken;
	}

	public String getConsentUrl() {
		return consentUrl;
	}

	public void setConsentUrl(String consentUrl) {
		this.consentUrl = consentUrl;
	}

	public String getConsentStatusUrl() {
		return consentStatusUrl;
	}

	public void setConsentStatusUrl(String consentStatusUrl) {
		this.consentStatusUrl = consentStatusUrl;
	}

	public String getFinancialUrl() {
		return financialUrl;
	}

	public void setFinancialUrl(String financialUrl) {
		this.financialUrl = financialUrl;
	}

	public String getFinancialStatusUrl() {
		return financialStatusUrl;
	}

	public void setFinancialStatusUrl(String financialStatusUrl) {
		this.financialStatusUrl = financialStatusUrl;
	}

	public String getFinancialInformationUrl() {
		return financialInformationUrl;
	}

	public void setFinancialInformationUrl(String financialInformationUrl) {
		this.financialInformationUrl = financialInformationUrl;
	}

}
