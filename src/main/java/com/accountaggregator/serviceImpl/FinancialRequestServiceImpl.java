package com.accountaggregator.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.accountaggregator.service.FinancialRequestService;
import com.accountaggregator.service.SaswatApiLogs;
import com.accountaggregator.utils.FinancialRequest;
import com.accountaggregator.utils.PropertiesConfig;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@Service
public class FinancialRequestServiceImpl implements FinancialRequestService {

	@Autowired
	PropertiesConfig propertiesConfig;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	SaswatApiLogs saswatApiLogs;

	@Override
	public String fetchFinancialRequest(FinancialRequest financialRequest) {

		long timeStamp = System.currentTimeMillis();
		String apiName = "app/api/v3/accountAggregator/FI-request";
		String requestPacket = null;
		String Response = null;
		try {
			Gson gson = new Gson();
			requestPacket = gson.toJson(financialRequest);

			HttpHeaders headers = new HttpHeaders();
			headers.set("Authorization", propertiesConfig.getAccountAggregatorTocken());
			headers.set("Content-Type", "application/json");

			HttpEntity<Object> requestEntity = new HttpEntity<>(financialRequest, headers);
			Response = restTemplate.postForObject(propertiesConfig.getFinancialUrl(), requestEntity, String.class);

			ObjectMapper objectMapper = new ObjectMapper();

			JsonNode rootNode = objectMapper.readTree(Response);
			JsonNode resultNode = rootNode.get("result");
			String sessionId = resultNode.get("sessionId").asText();

			saswatApiLogs.saveFinancialRequestApiLogs(requestPacket, "SUCCESS", sessionId, apiName, timeStamp);

		} catch (Exception e) {
			e.printStackTrace();
			String sessionId = "not getting the sessionId";
			Response = e.getMessage();
			saswatApiLogs.saveFinancialRequestApiLogs(requestPacket, Response, sessionId, apiName, timeStamp);
		}
		return Response;
	}

}
