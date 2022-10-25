package com.utkarsh.sms.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommonResponse {

	@JsonProperty("response_status")
	private String responseStatus;
	
	@JsonProperty("response_message")
	private String responseMessage;

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public CommonResponse(String responseStatus, String responseMessage) {
		super();
		this.responseStatus = responseStatus;
		this.responseMessage = responseMessage;
	}

	public CommonResponse() {
		super();
	}
	
	
}
