package com.utkarsh.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utkarsh.sms.entity.SchoolDetails;

public interface SchoolDetailsRepository extends JpaRepository<SchoolDetails, Integer> {
	
	SchoolDetails findBySchoolIdAndPassword(String schoolId, String Password);
	
	SchoolDetails findByEmailAndPassword(String emailId, String Password);
	
}
