package com.SeleniumUdemy.TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameterization {
	@BeforeMethod
	public void BMethod() {
		System.out.println("Before Method");
	}

	@AfterMethod
	public void AMethod() {
		System.out.println("After Method");
	}

//We can use this @Parameters Tag to call the variavles fom testng.xml file
	@Parameters({ "Name" })
	@Test
	public void Test(String name) {
		System.out.println("Inside Test");
		System.out.println(name);
	}

//DataProvider
	@DataProvider
	public Object[][] getData() {
		Object data[][]=new Object[4][1];
		//Object data[][]=new Object[no. of combinations][no. of variables];
		data[0][0]="Abdul Jamadar";
		data[1][0]="Sana Jamadar";
		data[2][0]="Tasnim Jamadar";
		data[3][0]="Lalesa Jamadar";
		return data;
	}
	
	@Test(dataProvider = "getData")
	public void Run(String name) {
		System.out.println(name);
	}
}
