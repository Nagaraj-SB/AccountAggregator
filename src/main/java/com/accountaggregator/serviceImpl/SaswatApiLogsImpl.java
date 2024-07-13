package com.accountaggregator.serviceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountaggregator.entity.ConsentRequestEntity;
import com.accountaggregator.entity.ConsentStatusEntity;
import com.accountaggregator.entity.FinancialInformationEntity;
import com.accountaggregator.entity.FinancialRequestEntity;
import com.accountaggregator.entity.FinancialStatusEnity;
import com.accountaggregator.repository.ConsentRequestRepository;
import com.accountaggregator.repository.ConsentStatusRepository;
import com.accountaggregator.repository.FinancialInformationRepository;
import com.accountaggregator.repository.FinancialRequestRepository;
import com.accountaggregator.repository.FinancialStatusRepository;
import com.accountaggregator.service.SaswatApiLogs;

@Service
public class SaswatApiLogsImpl implements SaswatApiLogs {

	@Autowired
	ConsentRequestRepository consentRequestRepository;

	@Autowired
	ConsentStatusRepository consentStatusRepository;

	@Autowired
	FinancialInformationRepository financialInformationRepository;

	@Autowired
	FinancialRequestRepository financialRequestRepository;

	@Autowired
	FinancialStatusRepository financialStatusRepository;

	@Override
	public void saveConsentRequestApiLogs(String consentRequest, String consentHandleId, String ResponseStatus, String apiName,
			long timeStamp) {

		try {
			Date date = new Date();
			ConsentRequestEntity consentRequestEntity = new ConsentRequestEntity();
			
			consentRequestEntity.setRequestPacket(consentRequest);
			consentRequestEntity.setConsentHandleId(consentHandleId);
			consentRequestEntity.setResponse(ResponseStatus);
			consentRequestEntity.setApiName(apiName);
			consentRequestEntity.setTimeStamp(date);
			consentRequestRepository.save(consentRequestEntity);

		} catch (Exception e) {

		}

	}

	@Override
	public void saveConsentStatusApiLogs(String consentStatusRequest, String response, String apiName, String consentId,
			long timeStamp) {
		try {
			Date date = new Date();
			ConsentStatusEntity consentStatusEntity = new ConsentStatusEntity();

			consentStatusEntity.setRequestPacket(consentStatusRequest);
			consentStatusEntity.setConsentId(consentId);
			consentStatusEntity.setResponse(response);
			consentStatusEntity.setApiName(apiName);
			consentStatusEntity.setTimeStamp(date);
			consentStatusRepository.save(consentStatusEntity);

		} catch (Exception e) {

		}

	}

	@Override
	public void saveFinancialInformationApiLogs(String financialInformationRequest, String response, String AAResponse,
			String apiName, long timeStamp) {
		try {
			Date date = new Date();
			FinancialInformationEntity financialInformationEntity = new FinancialInformationEntity();

			financialInformationEntity.setRequestPacket(financialInformationRequest);
			financialInformationEntity.setAAResponse(AAResponse);
			financialInformationEntity.setResponse(response);
			financialInformationEntity.setApiName(apiName);
			financialInformationEntity.setTimeStamp(date);
			financialInformationRepository.save(financialInformationEntity);
		} catch (Exception e) {

		}

	}

	@Override
	public void saveFinancialRequestApiLogs(String financialRequest, String response, String sessionId, String apiName,
			long timeStamp) {
		try {
			Date date = new Date();
			FinancialRequestEntity financialRequestEntity = new FinancialRequestEntity();

			financialRequestEntity.setRequestPacket(financialRequest);
			financialRequestEntity.setSessionId(sessionId);
			financialRequestEntity.setResponse(response);
			financialRequestEntity.setApiName(apiName);
			financialRequestEntity.setTimeStamp(date);
			financialRequestRepository.save(financialRequestEntity);

		} catch (Exception e) {

		}

	}

	@Override
	public void saveFinancialStatusEnityApiLogs(String financialStatusRequest, String response, String fiRequestStatus,
			String apiName, long timeStamp) {
		try {
			Date date = new Date();
			FinancialStatusEnity financialStatusEnity = new FinancialStatusEnity();

			financialStatusEnity.setRequestPacket(financialStatusRequest);
			financialStatusEnity.setFiRequestStatus(fiRequestStatus);
			financialStatusEnity.setResponse(response);
			financialStatusEnity.setApiName(apiName);
			financialStatusEnity.setTimeStamp(date);
			financialStatusRepository.save(financialStatusEnity);
		} catch (Exception e) {

		}

	}

}
