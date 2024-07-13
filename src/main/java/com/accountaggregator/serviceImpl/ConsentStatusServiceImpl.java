package com.accountaggregator.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.accountaggregator.service.ConsentStatusService;
import com.accountaggregator.service.SaswatApiLogs;
import com.accountaggregator.utils.ConsentStatusRequest;
import com.accountaggregator.utils.PropertiesConfig;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@Service
public class ConsentStatusServiceImpl implements ConsentStatusService {

	@Autowired
	PropertiesConfig propertiesConfig;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	SaswatApiLogs saswatApiLogs;

	@Override
	public String fetchConsentStatus(ConsentStatusRequest consentStatusRequest) {

		long timeStamp = System.currentTimeMillis();
		String apiName = "app/api/v3/accountAggregator/consent-status";
		String requestPacket = null;
		String Response = null;

		try {
			Gson gson = new Gson();
			requestPacket = gson.toJson(consentStatusRequest);

			HttpHeaders headers = new HttpHeaders();
			headers.set("Authorization", propertiesConfig.getAccountAggregatorTocken());
			headers.set("Content-Type", "application/json");

			HttpEntity<Object> requestEntity = new HttpEntity<>(consentStatusRequest, headers);
			Response = restTemplate.postForObject(propertiesConfig.getConsentStatusUrl(), requestEntity, String.class);

			ObjectMapper objectMapper = new ObjectMapper();

			JsonNode rootNode = objectMapper.readTree(Response);
			JsonNode resultNode = rootNode.get("result");
			String consentId = resultNode.get("consentId").asText();

			saswatApiLogs.saveConsentStatusApiLogs(requestPacket, "SUCCESS", apiName, consentId, timeStamp);

		} catch (Exception e) {
			e.printStackTrace();
			String consentId = "not getting the consentId";
			Response = e.getMessage();
			saswatApiLogs.saveConsentStatusApiLogs(requestPacket, Response, apiName, consentId, timeStamp);
		}
		return Response;
	}

}