package com.utkarsh.sms.service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Base64;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utkarsh.sms.beans.AddSchoolDetailsRequest;
import com.utkarsh.sms.beans.AddSchoolDetailsResponse;
import com.utkarsh.sms.beans.LoginResponse;
import com.utkarsh.sms.beans.StudentRequest;
import com.utkarsh.sms.beans.StudentResponse;
import com.utkarsh.sms.entity.SchoolDetails;
import com.utkarsh.sms.entity.StudentDetails;
import com.utkarsh.sms.enums.SchoolEnums.Gender;
import com.utkarsh.sms.enums.SchoolEnums.StudentStatus;
import com.utkarsh.sms.repository.SchoolDetailsRepository;
import com.utkarsh.sms.repository.StudentDetailsRepository;

@Service
public class SchoolService {
	
	@Autowired
	SchoolDetailsRepository schoolDetailsRepository;
	
	@Autowired
	StudentDetailsRepository studentDetailsRepository;

	public AddSchoolDetailsResponse addSchoolDetails(HttpServletResponse response,
			AddSchoolDetailsRequest addSchoolDetailsRequest) {
		
		AddSchoolDetailsResponse addSchoolDetailsResponse = null;
		String responseStatus = null;
		String responseMessage = null;
		SchoolDetails schoolDetails = this.createSchoolDetailsEntry(addSchoolDetailsRequest);
		
		if(null == schoolDetails) {
			
			responseStatus = "500";
			responseMessage = "Error while adding data to DB";
			addSchoolDetailsResponse = new AddSchoolDetailsResponse(responseStatus, responseMessage);
			response.setStatus(500);
			return addSchoolDetailsResponse;
		}
		
		responseStatus = "201";
		responseMessage = "School Registered successfully";
		addSchoolDetailsResponse = new AddSchoolDetailsResponse(responseStatus, responseMessage);
		addSchoolDetailsResponse.setSchoolId(schoolDetails.getSchoolId());
		response.setStatus(201);
		return addSchoolDetailsResponse;
		
		
	}

	private SchoolDetails createSchoolDetailsEntry(AddSchoolDetailsRequest addSchoolDetailsRequest) {
		
		SchoolDetails output = null;
		try {
			
			SchoolDetails schoolDetails = new SchoolDetails();
			schoolDetails.setSchoolId(addSchoolDetailsRequest.getSchoolName().substring(0,4)+addSchoolDetailsRequest.getCity().substring(0,4));
			schoolDetails.setSchoolName(addSchoolDetailsRequest.getSchoolName());
			schoolDetails.setPhoneNumber(addSchoolDetailsRequest.getPhoneNumber());
			schoolDetails.setEmail(addSchoolDetailsRequest.getEmail());
			schoolDetails.setArea(addSchoolDetailsRequest.getArea());
			schoolDetails.setCity(addSchoolDetailsRequest.getCity());
			schoolDetails.setState(addSchoolDetailsRequest.getState());
			schoolDetails.setPincode(addSchoolDetailsRequest.getPincode());
			schoolDetails.setPassword(addSchoolDetailsRequest.getPassword());
			output = schoolDetails;
			schoolDetailsRepository.save(output);
			
		} catch(Exception e) {
			
			System.err.println(e);
		}
		
		return output;
		
	}

	public LoginResponse addSchoolDetails(HttpServletResponse response, String userName, String password) {

		LoginResponse loginResponse = new LoginResponse();
		
		byte[] decodedByte = Base64.getDecoder().decode(password);
		String decodedKey = new String(decodedByte, StandardCharsets.UTF_8);
		
		SchoolDetails schoolDetails = schoolDetailsRepository.findBySchoolIdAndPassword(userName, decodedKey);
		
		if(null == schoolDetails) {
			
			schoolDetails = schoolDetailsRepository.findByEmailAndPassword(userName, decodedKey);
		}
		
		if(null == schoolDetails) {
			
			System.err.println("school does not exist with the provied credentials");
			response.setStatus(400);
			loginResponse.setResponseMessage("Username or password is incorrect");
			return loginResponse;
		}
		
		System.err.println("school exist with the provied credentials");
		response.setStatus(200);
		loginResponse.setResponseMessage("Login Success");
		loginResponse.setSchoolId(schoolDetails.getSchoolId());
		return loginResponse;
	}

	public StudentResponse addStudentDetails(HttpServletResponse response, StudentRequest studentRequest) {
		// TODO Auto-generated method stub
		
		StudentResponse studentResponse = null;
		String responseStatus = null;
		String responseMessage = null;
		StudentDetails studentDetails = this.createStudentEntry(studentRequest);
		if(null == studentDetails) {
			
			responseStatus = "500";
			responseMessage = "Error while adding data to DB";
			studentResponse = new StudentResponse(responseStatus, responseMessage);
			response.setStatus(500);
			return studentResponse;
		}
		
		responseStatus = "201";
		responseMessage = "Student Details added successfully";
		studentResponse = new StudentResponse(responseStatus, responseMessage);
		response.setStatus(201);
		return studentResponse;
	}

	private StudentDetails createStudentEntry(StudentRequest studentRequest) {

		StudentDetails output = null;
		try {
			
			StudentDetails studentDetails = new StudentDetails();
			studentDetails.setUniqueId(studentRequest.getUniqueId());
			studentDetails.setStudentName(studentRequest.getStudentName());
			studentDetails.setStudentStatus(studentRequest.getStudentStatus());
			studentDetails.setSchoolId(studentRequest.getSchoolId());
			studentDetails.setGuardianName(studentRequest.getGuardianName());
			studentDetails.setCaste(studentRequest.getCaste());
			studentDetails.setCurrentClass(studentRequest.getCurrentClass());
			studentDetails.setEmail(studentRequest.getEmail());
			studentDetails.setFatherName(studentRequest.getFatherName());
			studentDetails.setGender(Gender.MALE);
//			studentDetails.setGender(studentRequest.getGender());
			studentDetails.setHouse(studentRequest.getHouse());
			studentDetails.setArea(studentRequest.getArea());
			studentDetails.setCity(studentRequest.getCity());
			studentDetails.setState(studentRequest.getState());
			studentDetails.setLastSchoolClassAttended(studentRequest.getLastSchoolAttended());
			studentDetails.setLastSchoolAttended(studentRequest.getLastSchoolAttended());
			studentDetails.setMobileNumber(studentRequest.getMobileNumber());
			studentDetails.setMotherName(studentRequest.getMotherName());
			studentDetails.setOtherNumber(studentRequest.getOtherNumber());
			studentDetails.setPincode(studentRequest.getPincode());
			studentDetails.setReligion(studentRequest.getReligion());
			studentDetails.setWhatsappNumber(studentRequest.getWhatsappNumber());
			if(studentRequest.getStudentStatus() == StudentStatus.ENQUIRY) {
				studentDetails.setEnquiryDate(LocalDateTime.now());
			} else if(studentRequest.getStudentStatus() == StudentStatus.NEW) {
				studentDetails.setAdmissionDate(LocalDateTime.now());
			} else if(studentRequest.getStudentStatus() == StudentStatus.DROPOUT || studentRequest.getStudentStatus() == StudentStatus.PASSOUT) {
				studentDetails.setLeavingDate(LocalDateTime.now());
			}  
			output = studentDetails;
			studentDetailsRepository.save(output);
			
		} catch(Exception e) {
			
			System.err.println(e);
		}
		
		return output;
	}

	
}
