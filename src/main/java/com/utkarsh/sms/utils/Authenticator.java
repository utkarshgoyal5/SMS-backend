package com.utkarsh.sms.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.stereotype.Component;

@Component
public class Authenticator {

	public boolean authorizeSchool(String schoolKey, String actualKey, String Identifier) {
		
		try {
			
			if(null == schoolKey || null == actualKey) {
				System.err.println("Null Key Found");
				return false;
			}
			
			byte[] decodedByte = Base64.getDecoder().decode(schoolKey);
			String decodedKey = new String(decodedByte, StandardCharsets.UTF_8);
			
			if(actualKey.equals(decodedKey)) {
				System.err.println("Key Matched!");
				return true;
			}
			
		} catch(Exception e) {
			
			System.err.println("Cought into an error");
		}
		
		System.err.println("Key can't be Matched!");
		
		return false;
	}
}
