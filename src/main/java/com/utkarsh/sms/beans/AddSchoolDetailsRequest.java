package com.utkarsh.sms.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddSchoolDetailsRequest {

	@JsonProperty("school_name")
	private String schoolName;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("phone_number")
	private String phoneNumber;
	
	@JsonProperty("area")
	private String area;
	
	@JsonProperty("city")
	private String city;
	
	@JsonProperty("state")
	private String state;
	
	@JsonProperty("pincode")
	private String pincode;
	
	@JsonProperty("password")
	private String password;

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AddSchoolDetailsRequest(String schoolName, String email, String phoneNumber, String area, String city,
			String state, String pincode, String password) {
		super();
		this.schoolName = schoolName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.password = password;
	}

	public AddSchoolDetailsRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
