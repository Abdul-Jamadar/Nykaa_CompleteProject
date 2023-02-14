//Groups:
/*
If we want to run only selected test cases among all the test cases then 
we should use groups.
<groups>
		<run>
			<include name="Smoke" />
		</run>
</groups>
*/
//To ignore test case while executing we can use attribute Test(enabled="false").
//To make a method depend on another we can use Test(dependsOnMethods={""}) attribute.
//We can use parameterisation using the xml file where we can use attribute <Parameter name="" value="">
//to pass parameters to a test case.

package com.SeleniumUdemy.TestNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HelperAttributes {
	@Parameters("URL")
	@Test()
	public void run1(String url) {
		System.out.println("In 2nd Test printing url="+url);
	}

	@AfterTest
	public void method1() {
		System.out.println("In 2nd After Test");
	}

	@BeforeTest
	public void driverSetup() {
		System.out.println("In 2nd BeforeTest");
	}
}
