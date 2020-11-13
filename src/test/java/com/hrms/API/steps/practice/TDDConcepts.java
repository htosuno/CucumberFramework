package com.hrms.API.steps.practice;

import org.testng.annotations.Test;

public class TDDConcepts {
	
	@Test
	public void hello() {
		System.out.println("I will say welcome if someone knocks on my door");
	}
	
	@Test(dependsOnMethods = {"hello"})
	public void welcome() {
		System.out.println("I will welcome someone ONLY if there was someone that knocked on my door");
	}
	
	//@Test
	public void tea() {
		System.out.println("I will serve tea to whoever I welcomed to my house");
	}
	

}
