package com.utkarsh.sms.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.utkarsh.sms.enums.SchoolEnums.Gender;
import com.utkarsh.sms.enums.SchoolEnums.StudentStatus;

import lombok.Data;

@Entity
@Table(name = "student_details")
@Data
@JsonInclude(Include.NON_NULL)
public class StudentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	@Column(name = "id") 
	private Integer id;
	
	@JsonProperty("school_id")
	@Column(name = "school_id")
	private String schoolId;
	
	@JsonProperty("unique_id")
	@Column(name = "unique_id")
	private String uniqueId;
	
	@JsonProperty("student_name")
	@Column(name = "student_name")
	private String studentName;	
	
	@JsonProperty("student_status")
	@Column(name = "student_status")
	@Enumerated(EnumType.STRING)
	private StudentStatus studentStatus;
	
	@JsonProperty("gender")
	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@JsonProperty("current_class")
	@Column(name = "current_class")
	private String currentClass;
	
	@JsonProperty("mother_name")
	@Column(name = "mother_name")
	private String motherName;
	
	@JsonProperty("father_name")
	@Column(name = "father_name")
	private String fatherName;
	
	@JsonProperty("mobile_number")
	@Column(name = "mobile_number")
	private String mobileNumber;

	@JsonProperty("whatsapp_number")
	@Column(name = "whatsapp_number")
	private String whatsappNumber;
	
	@JsonProperty("other_number")
	@Column(name = "other_number")
	private String otherNumber;
	
	@JsonProperty("email")
	@Column(name = "email")
	private String email;
	
	@JsonProperty("guardian_name")
	@Column(name = "guardian_name")
	private String guardianName;

	@JsonProperty("religion")
	@Column(name = "religion")
	private String religion;
	
	@JsonProperty("caste")
	@Column(name = "caste")
	private String caste;
	
	@JsonProperty("last_school_attended")
	@Column(name = "last_school_attended")
	private String lastSchoolAttended;
	
	@JsonProperty("last_school_class_attended")
	@Column(name = "last_school_class_attended")
	private String lastSchoolClassAttended;
	
	@JsonProperty("house")
	@Column(name = "house")
	private String house;
	
	@JsonProperty("area")
	@Column(name = "area") 
	private String area;
	
	@JsonProperty("city")
	@Column(name = "city")
	private String city;
	
	@JsonProperty("state")
	@Column(name = "state")
	private String state;
	
	@JsonProperty("pincode")
	@Column(name = "pincode")
	private String pincode;
	
	@JsonProperty("optional")
	@Column(name = "optional")
	private String optional;
	
	@JsonProperty("enquiry_date")
	@Column(name = "enquiry_date")
	private LocalDateTime enquiryDate;
	
	@JsonProperty("admission_date")
	@Column(name = "admission_date")
	private LocalDateTime admissionDate;
	
	@JsonProperty("leaving_date")
	@Column(name = "leaving_date")
	private LocalDateTime leavingDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getOptional() {
		return optional;
	}

	public void setOptional(String optional) {
		this.optional = optional;
	}

	public LocalDateTime getEnquiryDate() {
		return enquiryDate;
	}

	public void setEnquiryDate(LocalDateTime enquiryDate) {
		this.enquiryDate = enquiryDate;
	}

	public LocalDateTime getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(LocalDateTime admissionDate) {
		this.admissionDate = admissionDate;
	}

	public LocalDateTime getLeavingDate() {
		return leavingDate;
	}

	public void setLeavingDate(LocalDateTime leavingDate) {
		this.leavingDate = leavingDate;
	}
	
}
