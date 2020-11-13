package com.hrms.API.steps.practice;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HardcodedExamples {
	/**
	 * REST Assured - Java library specifically developed to automate REST endpoints
	 * 
	 * Given - Preparing a request 
	 * When - What action will you perform, what type of
	 * call are you making? 
	 * Then - Verification
	 * 
	 */

	String baseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
	String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MDM2MzU3MjgsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYwMzY3ODkyOCwidXNlcklkIjoiMTI3OCJ9.J5-zJc6p-CPCfueTIwVzZXGVLYZYn2FkMyfdnQMu9IY";
	static String employeeID;

	// @Test
	public void sampleTest() {

		/*** BaseURI for all endpoints */
		// RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";

		/** JWT */

		/** Preparing request for /getOneEmployee.php */
		/** Using .log.all to print everything being sent with the request */
		RequestSpecification preparingGetOneEmployeeRequest = given().header("Authorization", token)
				.header("Content-Type", "application/json").queryParam("employee_id", "3695").log().all();

		/** Making call to /getOneEmployee.php */
		Response getOneEmployeeResponse = preparingGetOneEmployeeRequest.when().get("/getOneEmployee.php");

		/** One method to print response object */
//		System.out.println(getOneEmployeeResponse.asString());

		/** Second method to print response object */
		getOneEmployeeResponse.prettyPrint();

		/** Using assertThat() to verify status code */
		getOneEmployeeResponse.then().assertThat().statusCode(200);
	}

	@Test
	public void aPOSTcreateEmployee() {

		/** Preparing request for /createEmployee.php */
		RequestSpecification createEmployeeRequest = given().header("Authorization", token)
				.header("Content-Type", "application/json")
				.body("{\r\n" + "  \"emp_firstname\": \"Jhon\",\r\n" + "  \"emp_lastname\": \"Syntax\",\r\n"
						+ "  \"emp_middle_name\": \"Sss\",\r\n" + "  \"emp_gender\": \"M\",\r\n"
						+ "  \"emp_birthday\": \"2000-10-17\",\r\n" + "  \"emp_status\": \"Employee\",\r\n"
						+ "  \"emp_job_title\": \"Cloud Architect\"\r\n" + "}");
//				.log().all();

		/** Making call to /createEmployee.php */
		Response createEmployeeResponse = createEmployeeRequest.when().post("/createEmployee.php");

		/** Printing response */
//		createEmployeeResponse.prettyPrint();

		/**
		 * Using JsonPath() to view the response body which lets us to get employee ID
		 * We are storing the employeeIDas a static global variable to be able to use
		 * with other calls
		 */
		employeeID = createEmployeeResponse.jsonPath().getString("Employee[0].employee_id");

		/** Optional: Printing employeeID */
//		System.out.println(employeeID);

		/** Verifying status code is 201 */
		createEmployeeResponse.then().assertThat().statusCode(201);

		/**
		 * Verifying response body "Message" is paired with "Entry Created"; equalTo()
		 * method comes from static Hamcrest package - NEED TO IMPORT MANUALLY import
		 * static org.hamcrest.Matchers.*;
		 */
		createEmployeeResponse.then().assertThat().body("Message", equalTo("Entry Created"));

		/** Verifying created employee first name */
		createEmployeeResponse.then().assertThat().body("Employee[0].emp_firstname", equalTo("Jhon"));

		/** Verifying server Apache/2.4.39 (Win64) PHP/7.2.18 */
		createEmployeeResponse.then().assertThat().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");

	}

	@Test
	public void bGETcreatedEmployee() {

		/** Preparing request to get created employee */
		RequestSpecification getCreatedEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", employeeID);

		/** Storing response for retrieving created employee */
		Response getCreatedEmployeeResponse = getCreatedEmployeeRequest.when().get("/getOneEmployee.php");

		/** Printing response */
//		getCreatedEmployeeResponse.prettyPrint();

		/**
		 * Storing response employee ID into empID to compare with global employee ID
		 */
		String empID = getCreatedEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");

		/** Comparing empID with stored employee ID from created employee */
		boolean verifyEmployeeID = empID.contentEquals(employeeID);

		/** Asserting to verify the above condition is true */
		Assert.assertTrue(verifyEmployeeID);

		/** Verifying status code is 200 */
		getCreatedEmployeeResponse.then().assertThat().statusCode(200);

		/**
		 * Storing full response as a string so that we are able to pass it as an
		 * argument with JsonPath
		 */
		String response = getCreatedEmployeeResponse.asString();

		/** Created object of JsonPath */
		JsonPath js = new JsonPath(response);

		/** Grabbing employee ID using 'js' */
		String employeeId = js.getString("employee[0].employee_id");
		String firstName = js.getString("employee[0].emp_firstname");
		String middleName = js.getString("employee[0].emp_middle_name");
		String lastName = js.getString("employee[0].emp_lastname");
		String birthday = js.getString("employee[0].emp_birthday");
		String gender = js.getString("employee[0].emp_gender");
		String jobTitle = js.getString("employee[0].emp_job_title");
		String status = js.getString("employee[0].emp_status");

		/** Assert response employee ID matches stored employee ID */
		Assert.assertTrue(employeeId.contentEquals(employeeID));

		Assert.assertEquals(firstName, "Jhon");
		Assert.assertEquals(middleName, "Sss");
		Assert.assertEquals(lastName, "Syntax");
		Assert.assertEquals(birthday, "2000-10-17");
		Assert.assertEquals(gender, "Male");
		Assert.assertEquals(jobTitle, "Cloud Architect");
		Assert.assertEquals(status, "Employee");
	}

	//@Test
	public void cGETallEmployees() {
		/** Preparing request to get all employees */
		RequestSpecification getAllEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token);

		/** Storing response for retrieving all employees */
		Response getAllEmployeeResponse = getAllEmployeeRequest.when().get("/getAllEmployees.php");

		/** Printing response */
//		getAllEmployeeResponse.prettyPrint();

		/** Storing full response as a string */
		String response = getAllEmployeeResponse.asString();

		/** Created object of JsonPath */
		JsonPath js = new JsonPath(response);

		/** Retrieving the size of the array (the number object in an array) */
		int count = js.getInt("Employees.size()");
//		System.out.println(count);

//		for (int i = 0; i < count; i++) {
//			String allEmployeeIDs = js.getString("Employees["+i+"].employee_id");
////			System.out.println(allEmployeeIDs);
//			
//			if(allEmployeeIDs.contentEquals(employeeID)) {
//				System.out.println("Employee ID: " + employeeID + " is present in the body");
//				String firstNameOfEmp = js.getString("Employees["+i+"].emp_firstname");
//				System.out.println(firstNameOfEmp);
//				break;
//			}
//
//		}
		
		/** for loop to print all first names all employees*/
//		for (int i = 0; i < count; i++) {
//			String allFirstnames = js.getString("Employees["+i+"].emp_firstname");
//			System.out.println(allFirstnames);
//			
//
//		}
		
	}
	@Test
	public void dPUTupdateCreatedEmployee() {
		/** Preparing request for /createEmployee.php */
		RequestSpecification updateCreatedEmployeeRequest = given().header("Authorization", token)
				.header("Content-Type", "application/json")
				.body("{\r\n" + 
						"  \"employee_id\": \""+employeeID+"\",\r\n" + 
						"  \"emp_firstname\": \"Syntax1\",\r\n" + 
						"  \"emp_lastname\": \"Techs1\",\r\n" + 
						"  \"emp_middle_name\": \"C1\",\r\n" + 
						"  \"emp_gender\": \"F\",\r\n" + 
						"  \"emp_birthday\": \"2002-01-01\",\r\n" + 
						"  \"emp_status\": \"Worker\",\r\n" + 
						"  \"emp_job_title\": \"Instructor\"\r\n" + 
						"}");
//				.log().all();

		/** Making call to /createEmployee.php */
		Response putUpdateCreatedEmployeeResponse = updateCreatedEmployeeRequest.when().put("/updateEmployee.php");

		/** Printing response */
		putUpdateCreatedEmployeeResponse.prettyPrint();
		
		/**
		 * Storing full response as a string so that we are able to pass it as an
		 * argument with JsonPath
		 */
		String response = putUpdateCreatedEmployeeResponse.asString();

		/** Created object of JsonPath */
		JsonPath js = new JsonPath(response);

		/** Grabbing employee ID using 'js' */
		String employeeId = js.getString("employee[0].employee_id");
		String firstName = js.getString("employee[0].emp_firstname");
		String middleName = js.getString("employee[0].emp_middle_name");
		String lastName = js.getString("employee[0].emp_lastname");
		String birthday = js.getString("employee[0].emp_birthday");
		String gender = js.getString("employee[0].emp_gender");
		String jobTitle = js.getString("employee[0].emp_job_title");
		String status = js.getString("employee[0].emp_status");

		/** Assert response employee ID matches updated employee ID */
		Assert.assertTrue(employeeId.contentEquals(employeeID));

		Assert.assertEquals(firstName, "Syntax1");
		Assert.assertEquals(middleName, "C1");
		Assert.assertEquals(lastName, "Techs1");
		Assert.assertEquals(birthday, "2002-01-01");
		Assert.assertEquals(gender, "Female");
		Assert.assertEquals(jobTitle, "Instructor");
		Assert.assertEquals(status, "Worker");

	}

}
