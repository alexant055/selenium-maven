package com.selenium.maven;

import org.testng.annotations.Test;

public class SeleniumTest {

	@Test(dependsOnMethods= {"elementsUI"})
	public void browserAutomation() {
		System.out.println("Browser Automation!");
	}
	
	@Test
	public void elementsUI() {
		System.out.println("Elements UI!");
	}
	
}
