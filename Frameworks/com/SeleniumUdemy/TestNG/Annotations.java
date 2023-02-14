package com.SeleniumUdemy.TestNG;

import org.testng.annotations.*;

import com.Selenium.basics.BaseClass;

public class Annotations extends BaseClass {

	//  We can use <include> and <exclude> to customize methods in TestNG XML.
	//  ALso we can use <include name='methodnameinitials.*'/> as a regex .
	//  Sequence of TestNG annotations: 
	//	beforeSuite
	//	beforeTest
	//	beforeClass
	//	beforeMethods
	//	Test
	//  afterMethods
	//	afterClass
	//	afterTest
	//	afterSuite
	
	@BeforeSuite
	public void BSuite() {
		System.out.println("In Before Suite");
	}
	
	@AfterSuite
	public void ASuite() {
		System.out.println("In After Suite");
	}
	
	@BeforeTest
	public void driverSetup() {
		System.out.println("In BeforeTest");
		}

	@Parameters("URL")
	@Test
	public void run(String url) {
		System.out.println("In Test 1 printing url="+url);
	}

	@Test(groups = { "Smoke" })
	public void run1() {
		System.out.println("In Test 2");
	}
	
	@AfterTest
	public void method1() {
		System.out.println("In After Test");
	}
	
	@BeforeMethod
	public void BMethod() {
		System.out.println("In BeforeMethod");
		}

	@AfterMethod
	public void AMethod() {
		System.out.println("In AfterMethod");
		}
	
	@BeforeClass
	public void BClass() {
		System.out.println("In BeforeClass");
		}

	@AfterClass
	public void AClass() {
		System.out.println("In AfterClass");
		}
}
