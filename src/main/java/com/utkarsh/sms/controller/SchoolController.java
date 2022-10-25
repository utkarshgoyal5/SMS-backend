package com.utkarsh.sms.controller;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.utkarsh.sms.beans.AddSchoolDetailsRequest;
import com.utkarsh.sms.beans.AddSchoolDetailsResponse;
import com.utkarsh.sms.beans.GetStudentEnquiresListResponse;
import com.utkarsh.sms.beans.LoginResponse;
import com.utkarsh.sms.beans.StudentRequest;
import com.utkarsh.sms.beans.StudentResponse;
import com.utkarsh.sms.entity.SchoolDetails;
import com.utkarsh.sms.entity.StudentDetails;
import com.utkarsh.sms.enums.SchoolEnums.StudentStatus;
import com.utkarsh.sms.repository.SchoolDetailsRepository;
import com.utkarsh.sms.repository.StudentDetailsRepository;
import com.utkarsh.sms.service.SchoolService;
import com.utkarsh.sms.utils.Utility;

@RestController
public class SchoolController {
	
	@Autowired
	SchoolDetailsRepository schoolDetailsRepository;
	
	@Autowired
	SchoolService schoolService;
	
	@Autowired
	StudentDetailsRepository studentDetailsRepository;
	
	@GetMapping("/loginRequest")
	public LoginResponse loginRequest(HttpServletResponse response, @RequestParam(value = "user_name") String userName,
			@RequestParam(value = "password") String password) {
		
		LoginResponse loginResponse = new LoginResponse(); 
		if(null == password) {
			System.err.println("Not received password in request");
			response.setStatus(400);
			loginResponse.setResponseMessage("Not received password in request");
			return loginResponse;
		}
		
		loginResponse = schoolService.addSchoolDetails(response, userName, password);
		System.err.println("Login response: " + loginResponse.toString());
		return loginResponse;
	}
	
	@PostMapping("/addSchoolDetails")
	public AddSchoolDetailsResponse addSchoolDetails(HttpServletResponse response, @RequestBody AddSchoolDetailsRequest addSchoolDetailsRequest) {
		
		AddSchoolDetailsResponse addSchoolDetailsResponse = null;
		String responseStatus = null;
		String responseMessage = null;
		
		if(Utility.isNullOrEmpty(addSchoolDetailsRequest.getSchoolName())) {
			
			responseStatus = "400";
			responseMessage = "School name not found in the request";
			addSchoolDetailsResponse = new AddSchoolDetailsResponse(responseStatus, responseMessage);
			response.setStatus(400);
			return addSchoolDetailsResponse;
		}
		
		if(Utility.isNullOrEmpty(addSchoolDetailsRequest.getPhoneNumber())) {
			
			responseStatus = "400";
			responseMessage = "School phone number not found in the request";
			addSchoolDetailsResponse = new AddSchoolDetailsResponse(responseStatus, responseMessage);
			response.setStatus(400);
			return addSchoolDetailsResponse;
		}
		
		if(Utility.isNullOrEmpty(addSchoolDetailsRequest.getPassword())) {
			
			responseStatus = "400";
			responseMessage = "School password not found in the request";
			addSchoolDetailsResponse = new AddSchoolDetailsResponse(responseStatus, responseMessage);
			response.setStatus(400);
			return addSchoolDetailsResponse;
		}
		
		addSchoolDetailsResponse = schoolService.addSchoolDetails(response, addSchoolDetailsRequest);
	
		return addSchoolDetailsResponse;
	}
	
	@PostMapping("/addStudentDetails")
	public StudentResponse addStudentDetails(HttpServletResponse response, @RequestBody StudentRequest studentRequest) {
		
		System.err.println(studentRequest.toString());
		
		StudentResponse studentResponse = null;
		String responseStatus = null;
		String responseMessage = null;
		
		if(Utility.isNullOrEmpty(studentRequest.getStudentName())) {
			
			responseStatus = "400";
			responseMessage = "Student name not found in the request";
			studentResponse = new StudentResponse(responseStatus, responseMessage);
			response.setStatus(400);
			return studentResponse;
		}
		
		if(Utility.isNullOrEmpty(studentRequest.getMobileNumber())) {
			
			responseStatus = "400";
			responseMessage = "Student phone number not found in the request";
			studentResponse = new StudentResponse(responseStatus, responseMessage);
			response.setStatus(400);
			return studentResponse;
		}
		
		studentResponse = schoolService.addStudentDetails(response, studentRequest);
	
		return studentResponse;
	}
	
	
	@GetMapping("/getStudentsEnquiryDetails")
	public @ResponseBody GetStudentEnquiresListResponse getStudentsEnquiryDetails(HttpServletResponse response, @RequestParam(value = "school_id") String schoolId, 
			 @RequestParam(value = "date", required = false) String enquiryDate) {
		
		GetStudentEnquiresListResponse getStudentEnquiresListResponse = null;
		String responseStatus = null;
		String responseMessage = null;
		
		List<StudentDetails> studentEnquiryList = new ArrayList<StudentDetails>();
		
		studentEnquiryList = studentDetailsRepository.findBySchoolIdAndStudentStatus(schoolId, StudentStatus.ENQUIRY);
		
		if(null == studentEnquiryList || studentEnquiryList.isEmpty()) {
			
			responseStatus = "400";
			responseMessage = "No Student Enquiry found";
			getStudentEnquiresListResponse = new GetStudentEnquiresListResponse(responseStatus, responseMessage);
			response.setStatus(400);
			return getStudentEnquiresListResponse;
		}

		responseStatus = "200";
		responseMessage = "Student Enquiry found";
		getStudentEnquiresListResponse = new GetStudentEnquiresListResponse(responseStatus, responseMessage);
		getStudentEnquiresListResponse.setStudentEnquiresList(studentEnquiryList);
		response.setStatus(200);
		return getStudentEnquiresListResponse;
	}
}
