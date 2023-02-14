package Nykaa_resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	public static ExtentReports config() {
		String path = System.getProperty("user.dir") + "\\Nykaa_Project\\Reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Nykaa Automation Testing");
		reporter.config().setDocumentTitle("Test Results");

		ExtentReports report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Tester", "Abdullah J");
		return report;
	}
}
