package com.accountaggregator.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Financial_status")
public class FinancialStatusEnity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "request_packet")
	private String requestPacket;

	@Column(name = "fi_request_status")
	private String fiRequestStatus;

	@Column(name = "response")
	private String response;

	@Column(name = "api_name")
	private String apiName;

	@Column(name = "time_stamp")
	private Date timeStamp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRequestPacket() {
		return requestPacket;
	}

	public void setRequestPacket(String requestPacket) {
		this.requestPacket = requestPacket;
	}

	public String getFiRequestStatus() {
		return fiRequestStatus;
	}

	public void setFiRequestStatus(String fiRequestStatus) {
		this.fiRequestStatus = fiRequestStatus;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

}
