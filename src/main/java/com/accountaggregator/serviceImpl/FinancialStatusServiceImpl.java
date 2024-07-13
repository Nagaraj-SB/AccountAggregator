package com.accountaggregator.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.accountaggregator.service.FinancialStatusService;
import com.accountaggregator.service.SaswatApiLogs;
import com.accountaggregator.utils.FinancialStatusRequest;
import com.accountaggregator.utils.PropertiesConfig;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@Service
public class FinancialStatusServiceImpl implements FinancialStatusService {

	@Autowired
	PropertiesConfig propertiesConfig;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	SaswatApiLogs saswatApiLogs;

	@Override
	public String fetchFinancialStatus(FinancialStatusRequest financialStatusRequest) {

		long timeStamp = System.currentTimeMillis();
		String apiName = "app/api/v3/accountAggregator/FI-request-status";
		String requestPacket = null;
		String Response = null;

		try {
			Gson gson = new Gson();
			requestPacket = gson.toJson(financialStatusRequest);

			HttpHeaders headers = new HttpHeaders();
			headers.set("Authorization", propertiesConfig.getAccountAggregatorTocken());
			headers.set("Content-Type", "application/json");

			HttpEntity<Object> requestEntity = new HttpEntity<>(financialStatusRequest, headers);
			Response = restTemplate.postForObject(propertiesConfig.getFinancialStatusUrl(), requestEntity,
					String.class);

			ObjectMapper objectMapper = new ObjectMapper();

			JsonNode rootNode = objectMapper.readTree(Response);
			JsonNode resultNode = rootNode.get("result");
			String fiRequestStatus = resultNode.get("fiRequestStatus").asText();

			saswatApiLogs.saveFinancialStatusEnityApiLogs(requestPacket, "SUCCESS", fiRequestStatus, apiName,
					timeStamp);

		} catch (Exception e) {
			e.printStackTrace();
			String fiRequestStatus = "fiRequestStatus is not in the ready state";
			Response = e.getMessage();
			saswatApiLogs.saveFinancialStatusEnityApiLogs(requestPacket, Response, fiRequestStatus, apiName, timeStamp);
		}
		return Response;
	}

}
