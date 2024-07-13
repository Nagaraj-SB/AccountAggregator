package com.accountaggregator.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.accountaggregator.service.FinancialInformationService;
import com.accountaggregator.service.SaswatApiLogs;
import com.accountaggregator.utils.FinancialInformationRequest;
import com.accountaggregator.utils.PropertiesConfig;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@Service
public class FinancialInformationServiceImpl implements FinancialInformationService {

	@Autowired
	PropertiesConfig propertiesConfig;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	SaswatApiLogs saswatApiLogs;

	@Override
	public String fetchFinancialInformation(FinancialInformationRequest financialInformationRequest) {

		long timeStamp = System.currentTimeMillis();
		String apiName = "app/api/v3/accountAggregator/FI-fetch-data";
		String requestPacket = null;
		String Response = null;
		try {
			Gson gson = new Gson();
			requestPacket = gson.toJson(financialInformationRequest);

			HttpHeaders headers = new HttpHeaders();
			headers.set("Authorization", propertiesConfig.getAccountAggregatorTocken());
			headers.set("Content-Type", "application/json");

			HttpEntity<Object> requestEntity = new HttpEntity<>(financialInformationRequest, headers);
			Response = restTemplate.postForObject(propertiesConfig.getFinancialInformationUrl(), requestEntity,
					String.class);
			ObjectMapper objectMapper = new ObjectMapper();

			JsonNode rootNode = objectMapper.readTree(Response);
			JsonNode resultNode = rootNode.get("result");
			String AAResponse = resultNode.get("AAResponse").asText();

			saswatApiLogs.saveFinancialInformationApiLogs(requestPacket, "SUCCESS", AAResponse, apiName, timeStamp);

		} catch (Exception e) {
			e.printStackTrace();
			String AAResponse = "not getting the AAResponse";
			Response = e.getMessage();
			saswatApiLogs.saveFinancialInformationApiLogs(requestPacket, Response, AAResponse, apiName, timeStamp);
		}
		return Response;
	}

}
