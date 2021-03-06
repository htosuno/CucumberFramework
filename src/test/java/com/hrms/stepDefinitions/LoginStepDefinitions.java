package com.hrms.stepDefinitions;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions extends CommonMethods {

	@When("login with valid credentials")
	public void login_with_valid_credentials() {
		login.loginToHrms( ConfigsReader.getPropValue("username"), ConfigsReader.getPropValue("password"));
	}

	@Then("verify the dashboard logo is displayed")
	public void verify_the_dashboard_logo_is_displayed() {
		Assert.assertTrue(dash.welcomeMessage.isDisplayed());
	}
	
	@When("login with invalid credentials")
	public void login_with_invalid_credentials() {
		login.loginToHrms( "Admin11", "Syntax");
	}

	@Then("verify the error message")
	public void verify_the_error_message() {
		Assert.assertTrue(login.spanMessage.isDisplayed());
	}
	
	
}
