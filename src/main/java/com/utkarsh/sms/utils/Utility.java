package com.utkarsh.sms.utils;

public class Utility {

	public static boolean isNullOrEmpty(String prop) {
		
		if(null == prop || prop.trim().isEmpty() || prop.equalsIgnoreCase("null")) {
			
			return true;
		}
		return false;
	}
}
