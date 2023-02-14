package com.SeleniumUdemy.Projects;

import java.time.Duration;
import java.util.Arrays;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class myntraTestNG {
	public static void main(String args[]) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		Actions action = new Actions(driver);
		Scanner sc = new Scanner(System.in);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		String searchFor = "";
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		

		// Login Scenario
		WebElement w1 = driver.findElement(By.xpath("//span[contains(text(),'Profile')]"));
		action.moveToElement(w1).build().perform();
		driver.findElement(By.xpath("//*[contains(text(),'login / Signup')]")).click();
		driver.findElement(By.cssSelector("input[class*='mobile']")).sendKeys("9822782485" + Keys.ENTER);
//		wait.until(
//				ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='sec-if-customtext-container']")));
		Thread.sleep(30000);
		driver.findElement(By.cssSelector("input[class*='mobile']")).sendKeys(Keys.ENTER);
		System.out.println("Enter 4 digit OTP: ");
		String Otp = sc.next();
		Thread.sleep(5000);
		for (int i = 0; i < Otp.length(); i++) {
			driver.findElement(By.cssSelector("input[name='otp" + i + "']")).sendKeys("" + Otp.charAt(i));
		}
		Thread.sleep(5000);
		
		//Verify Login
		WebElement w3 = driver.findElement(By.cssSelector("div.desktop-user"));
		wait.until(ExpectedConditions.visibilityOf(w3));
		action.moveToElement(w3).build().perform();
		String msg=driver.findElement(By.cssSelector("div.desktop-infoTitle")).getText();
		if(msg.contains("Abdul")) {
			System.out.println("Login Successful");
		}
		else
			System.out.println("Login Failed");

	}
}