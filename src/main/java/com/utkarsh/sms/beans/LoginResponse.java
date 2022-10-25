package com.utkarsh.sms.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponse extends CommonResponse {
	

	public LoginResponse(String responseStatus, String responseMessage) {
		super(responseStatus, responseMessage);
		// TODO Auto-generated constructor stub
	}

	public LoginResponse() {
		
		super();
	}
	
	public LoginResponse(String responseStatus, String responseMessage, String schoolId) {
		super(responseStatus, responseMessage);
		this.schoolId = schoolId;
	}

	@JsonProperty("school_id")
	private String schoolId;

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

}
