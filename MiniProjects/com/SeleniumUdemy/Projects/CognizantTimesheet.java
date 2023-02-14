package com.SeleniumUdemy.Projects;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

/*Lauch OneC
Login using mail and password and OTP 
Search timesheet and click view timesheet
Fill the timesheet as per user input
Submit timesheet and verify total hours against displayed total hrs. */

import com.Selenium.basics.BaseClass;

public class CognizantTimesheet extends BaseClass {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		initialize();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		// LOGIN
		String mailId = "2108112@cognizant.com";
		String password = "Selenium@0828";
		String OTP = null;
		String search = "Timesheet";
		driver.get("https://onecognizant.cognizant.com/Home");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys(mailId + Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(password + Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='table-row'])[1] ")));
		driver.findElement(By.xpath("(//div[@class='table-row'])[1] ")).click();
		System.out.println("Enter OTP: ");
		OTP = sc.next();
		while (OTP.equals(null)) {
			System.out.println("Please enter OTP: ");
			OTP = sc.next();
		}
		driver.findElement(By.xpath("//input[@name='otc']")).sendKeys(OTP + Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idSIButton9")));
		driver.findElement(By.id("idSIButton9")).click();

		// ENTER TIMESHEET PAGE
		driver.findElement(By.id("oneC_searchAutoComplete")).sendKeys(search + Keys.ENTER);
		List<WebElement> results = driver.findElements(
				By.xpath("//div[@class='row newSearchActionsAppsHolder']//div[@class='quickActionsResultText']"));
		// results.stream().filter(s->s.getText().contains("View
		// Timesheet")).map(s->getElement(s));
		for (int i = 0; i < results.size(); i++) {
			String str = results.get(i).getText();
			if (str.equalsIgnoreCase("view timesheet")) {
				results.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		Set<String> tabs = driver.getWindowHandles();
		Iterator<String> itr = tabs.iterator();
		while (itr.hasNext()) {
			String tab = itr.next();
			driver.switchTo().window(tab);
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@id='win0divCTS_TS_LAND_PER_$100$']//a[@class='ps-link'])[1]")));

		// Clicking on first date link
		WebElement topDate = driver.findElement(By.id("win0div$ICField44_row$0"));

		topDate.findElement(By.xpath("//div[@class='ps_box-link timesheet_period']")).click();
		driver.switchTo().frame("ptifrmtgtframe");
		driver.findElement(By.cssSelector("input[id*='CTS_MSTASK']")).sendKeys("000000000000011" + Keys.ENTER);
		Thread.sleep(2000);

		// Filling timesheet details: Submitting 9hrs/day for 5 days.
		for (int i = 3; i <= 5; i++) {
			// driver.findElement(By.xpath("(//table[@id='EX_TIME_DTL$scrolli$0']//td)["+i+"]//input")).click();
			driver.findElement(By.cssSelector("div[id='win0divTIME" + i + "$0'] input")).sendKeys("9" + Keys.ENTER);
			Thread.sleep(1000);
		}
		driver.findElement(By.cssSelector("INPUT[VALUE='Update Totals']")).click();

		// Verifying Total.
		Thread.sleep(2000);
		String sumOfHours = driver.findElement(By.xpath("//div[@id='win0divEX_TM_DT_DLY_WK_TOTAL$0']")).getText();
		System.out.println(sumOfHours);
		float sumHrs = Float.parseFloat(sumOfHours);
		System.out.println(sumHrs);
		if (sumHrs == 27.00) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);

		// Final Submit
		driver.findElement(By.cssSelector("input[name*='SUBMIT']")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("ptModFrame_0");
		driver.findElement(By.id("#ICSave")).click();

		// Return to Summary Page
		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector("input[value='Return to Timesheet Summary']")).click();

		// Taking status msg and hrs
		String status = topDate.findElement(By.xpath("//span[@id='CTS_TS_LAND_PER_CTS_TS_STATUS_LAND$0']")).getText();
		String finalHrs = topDate.findElement(By.xpath("//span[@id='CTS_TS_LAND_PER_CTS_TSC_TIME2$0']")).getText();
		String nonbillable = topDate.findElement(By.xpath("//div[@id='win0divCTS_TS_LAND_PER_CTS_TSC_TIME2lbl$0']"))
				.getText();
		System.out.println("\nStatus is: " + status + "\n" + nonbillable + "= " + finalHrs);

		// close
		driver.quit();

	}

}
