package com.SeleniumUdemy.Practice;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Selenium.basics.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Ola extends BaseClass {
	ExtentReports report;
	ExtentTest test;
	@BeforeTest
	public void config() {
		String path=System.getProperty("user.dir")+"\\PracticeScripts\\ExtentReporting\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Ola Automation");
		reporter.config().setDocumentTitle("Test Results");
		
		report= new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Tester", "Abdullah J");
	}

	@Test
	public void Test1() {
		// TODO Auto-generated method stub
		test=report.createTest("Ola Test");
		initialize();
		driver.get("https://www.olacabs.com/");
		System.out.println(driver.getTitle());
		test.fail("Fail");		
	}
	@Test
	public void Test2() {
		// TODO Auto-generated method stub
		test=report.createTest("Ola Test2");
		System.out.println(driver.getTitle());
		report.flush();
		driver.close();
		test.pass("Pass");
	}

}
