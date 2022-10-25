package com.utkarsh.sms.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.utkarsh.sms.entity.StudentDetails;

public class GetStudentEnquiresListResponse extends CommonResponse {

	@JsonProperty("student_enquires_list")
	private List<StudentDetails> studentEnquiresList;

	public List<StudentDetails> getStudentEnquiresList() {
		return studentEnquiresList;
	}

	public void setStudentEnquiresList(List<StudentDetails> studentEnquiresList) {
		this.studentEnquiresList = studentEnquiresList;
	}

	public GetStudentEnquiresListResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetStudentEnquiresListResponse(String responseStatus, String responseMessage) {
		super(responseStatus, responseMessage);
		// TODO Auto-generated constructor stub
	}

}
