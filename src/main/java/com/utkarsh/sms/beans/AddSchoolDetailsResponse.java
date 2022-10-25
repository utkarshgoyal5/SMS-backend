package com.utkarsh.sms.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddSchoolDetailsResponse extends CommonResponse {
	
	public AddSchoolDetailsResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddSchoolDetailsResponse(String responseStatus, String responseMessage) {
		super(responseStatus, responseMessage);
		// TODO Auto-generated constructor stub
	}

	@JsonProperty("school_id")
	private String schoolId;

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public AddSchoolDetailsResponse(String responseStatus, String responseMessage, String schoolId) {
		super(responseStatus, responseMessage);
		this.schoolId = schoolId;
	}
	
	
}
