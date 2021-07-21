package com.selenium.report;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemoTest {
	
	ExtentReports reports;

	@BeforeTest
	public void config() {
		String reportPath = System.getProperty("user.dir") + "/reports/index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Extened Demo Report");
		
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		
		reports.setSystemInfo("Tester", "Alexander, Antony");
	}
	
	@Test
	public void getReportDemo() {
		reports.createTest("Get Report initial Demo");
		
		String applicationUrl = "http://qaclickacademy.com/practice.php";
		// Find the OS name
		System.out.println(System.getProperty("os.name"));

		// Set the driver path to launch
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");

		// Instantiate the chrome driver
		WebDriver driver = new ChromeDriver();
		// Maximize the screen
		driver.manage().window().maximize();

		driver.get(applicationUrl);
		
		System.out.println(driver.getTitle());
		
		reports.flush();
	}
	
}
