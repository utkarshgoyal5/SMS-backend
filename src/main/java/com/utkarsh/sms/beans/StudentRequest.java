package com.utkarsh.sms.beans;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.utkarsh.sms.enums.SchoolEnums.Gender;
import com.utkarsh.sms.enums.SchoolEnums.StudentStatus;

public class StudentRequest {

	@JsonProperty("school_id")
	private String schoolId;
	
	@JsonProperty("unique_id")
	private String uniqueId;
	
	@JsonProperty("student_name")
	private String studentName;	
	
	@JsonProperty("student_status")
	@Enumerated(EnumType.STRING)
	private StudentStatus studentStatus;

	@JsonProperty("gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@JsonProperty("current_class")
	private String currentClass;
	
	@JsonProperty("mother_name")
	private String motherName;
	
	@JsonProperty("father_name")
	private String fatherName;
	
	@JsonProperty("mobile_number")
	private String mobileNumber;

	@JsonProperty("whatsapp_number")
	private String whatsappNumber;
	
	@JsonProperty("other_number")
	private String otherNumber;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("guardian_name")
	private String guardianName;

	@JsonProperty("religion")
	private String religion;
	
	@JsonProperty("caste")
	private String caste;
	
	@JsonProperty("last_school_attended")
	private String lastSchoolAttended;
	
	@JsonProperty("last_school_class_attended")
	private String lastSchoolClassAttended;
	
	@JsonProperty("house")
	private String house;
	
	@JsonProperty("area") 
	private String area;
	
	@JsonProperty("city")
	private String city;
	
	@JsonProperty("state")
	private String state;
	
	@JsonProperty("pincode")
	private String pincode;

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public StudentStatus getStudentStatus() {
		return studentStatus;
	}

	public void setStudentStatus(StudentStatus studentStatus) {
		this.studentStatus = studentStatus;
	}
	
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getCurrentClass() {
		return currentClass;
	}

	public void setCurrentClass(String currentClass) {
		this.currentClass = currentClass;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getWhatsappNumber() {
		return whatsappNumber;
	}

	public void setWhatsappNumber(String whatsappNumber) {
		this.whatsappNumber = whatsappNumber;
	}

	public String getOtherNumber() {
		return otherNumber;
	}

	public void setOtherNumber(String otherNumber) {
		this.otherNumber = otherNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGuardianName() {
		return guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public String getLastSchoolAttended() {
		return lastSchoolAttended;
	}

	public void setLastSchoolAttended(String lastSchoolAttended) {
		this.lastSchoolAttended = lastSchoolAttended;
	}

	public String getLastSchoolClassAttended() {
		return lastSchoolClassAttended;
	}

	public void setLastSchoolClassAttended(String lastSchoolClassAttended) {
		this.lastSchoolClassAttended = lastSchoolClassAttended;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
}
