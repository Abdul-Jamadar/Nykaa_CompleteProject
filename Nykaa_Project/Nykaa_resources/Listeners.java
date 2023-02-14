package Nykaa_resources;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Nykaa_Test._Test_Utility;

public class Listeners extends _Test_Utility implements ITestListener {

	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.config();
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
		// not implemented
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// not implemented
		extentTest.get().log(Status.PASS, "Test Passed Succesfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// not implemented
		String filepath = null;
		extentTest.get().fail(result.getThrowable());
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			filepath = TakeScreenshotAsLocation(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// not implemented
	}
	
	@Override
	public void onFinish(ITestContext context) {
	    // not implemented
		extent.flush();
	  }
}
