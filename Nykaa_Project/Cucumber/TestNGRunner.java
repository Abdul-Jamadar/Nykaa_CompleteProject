package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "Nykaa_Project\\Cucumber", glue = "Cucumber_StepDefinition", monochrome = true, tags = "@FullTest", plugin = {
		"html:target/cucumber.html" })
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
