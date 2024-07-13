package com.accountaggregator.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.accountaggregator.service.ConsentRequestService;
import com.accountaggregator.service.SaswatApiLogs;
import com.accountaggregator.utils.ConsentRequest;
import com.accountaggregator.utils.PropertiesConfig;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@Service
public class ConsentRequestServiceImpl implements ConsentRequestService {

	@Autowired
	PropertiesConfig propertiesConfig;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	SaswatApiLogs saswatApiLogs;

	@Override
	public String fetchConsentRequest(ConsentRequest consentRequest) {

		long timeStamp = System.currentTimeMillis();
		String apiName = "app/api/v3/accountAggregator/consent-request";
		String requestPacket = null;
		String Response = null;
		try {

			Gson gson = new Gson();
			requestPacket = gson.toJson(consentRequest);

			HttpHeaders headers = new HttpHeaders();
			headers.set("Authorization", propertiesConfig.getAccountAggregatorTocken());
			headers.set("Content-Type", "application/json");

			HttpEntity<Object> requestEntity = new HttpEntity<>(consentRequest, headers);
			Response = restTemplate.postForObject(propertiesConfig.getConsentUrl(), requestEntity, String.class);

			ObjectMapper objectMapper = new ObjectMapper();

			JsonNode rootNode = objectMapper.readTree(Response);
			JsonNode resultNode = rootNode.get("result");
			String consentHandle = resultNode.get("consentHandle").asText();

			saswatApiLogs.saveConsentRequestApiLogs(requestPacket, consentHandle, "SUCCESS", apiName, timeStamp);

		} catch (Exception e) {
			e.printStackTrace();
			String consentHandle = "not getting the consentHandle id";
			Response = e.getMessage();
			saswatApiLogs.saveConsentRequestApiLogs(requestPacket, consentHandle, Response, apiName, timeStamp);
		}
		return Response;
	}

}
