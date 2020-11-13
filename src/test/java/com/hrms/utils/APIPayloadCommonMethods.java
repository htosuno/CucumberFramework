package com.hrms.utils;

import org.json.JSONObject;

public class APIPayloadCommonMethods {

	public static String createEmployeeBody() {
		String ceretaEmployeeBody = "{\r\n" + "  \"emp_firstname\": \"Jhon\",\r\n"
				+ "  \"emp_lastname\": \"Syntax\",\r\n" + "  \"emp_middle_name\": \"Sss\",\r\n"
				+ "  \"emp_gender\": \"M\",\r\n" + "  \"emp_birthday\": \"2000-10-17\",\r\n"
				+ "  \"emp_status\": \"Employee\",\r\n" + "  \"emp_job_title\": \"Cloud Architect\"\r\n" + "}";
		return ceretaEmployeeBody;
	}

	public static String createEmployeePayloadMoreDynamic(String firstName, String lastName, String middleName,
			String gender, String dob, String employeeStatus, String employeeJobTitle) {
		JSONObject obj = new JSONObject();
		obj.put("emp_firstname", firstName);
		obj.put("emp_lastname", lastName);
		obj.put("emp_middle_name", middleName);
		obj.put("emp_gender", gender);
		obj.put("emp_birthday", dob);
		obj.put("emp_status", employeeStatus);
		obj.put("emp_job_title", employeeJobTitle);
		return obj.toString();
	}

}
