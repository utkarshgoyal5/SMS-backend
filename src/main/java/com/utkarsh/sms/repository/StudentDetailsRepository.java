package com.utkarsh.sms.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utkarsh.sms.entity.StudentDetails;
import com.utkarsh.sms.enums.SchoolEnums.StudentStatus;

public interface StudentDetailsRepository extends JpaRepository<StudentDetails, Integer> {
	
	List<StudentDetails> findBySchoolIdAndStudentStatus(String schoolId, StudentStatus studentStatus);
	
	List<StudentDetails> findBySchoolIdAndStudentStatusAndEnquiryDate(String schoolId, StudentStatus studentStatus, LocalDateTime enquiryDate);
}
